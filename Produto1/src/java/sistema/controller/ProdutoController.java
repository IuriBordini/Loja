
package sistema.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sistema.modelo.ItemPedido;
import sistema.modelo.Produto;

import sistema.modelo.ProdutoDao;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String produtos(@RequestParam (value = "pagina",defaultValue = "1") int pag, Model model){
        ProdutoDao dao = new ProdutoDao();
        dao.setPagina(pag);
        model.addAttribute("dados", dao.getProdutos());
        return "produtos";
    }
    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public String produto (@PathVariable long id, Model model){
        ProdutoDao dao = new ProdutoDao();
        Produto produto = dao.produtoId(id);
        model.addAttribute("produto",produto);
        return "produto";
    }
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar (Produto produto , Model model){
        ProdutoDao dao = new ProdutoDao();
        dao.cadastrar(produto);
        model.addAttribute("mensagem","Cadastrado com sucesso");
        return "produto-new";
    }
    @RequestMapping(value = "/atualizar", method = RequestMethod.POST)
    public String atualizar (Produto produto , RedirectAttributes ra, Model model){
        ProdutoDao dao = new ProdutoDao();
        dao.atualizar(produto);
        ra.addFlashAttribute("mensagem","Atualizado com sucesso");
        return "redirect:/produto/"+produto.getId();
    }
    @RequestMapping (value = "/excluir/(id)", method = RequestMethod.GET)
    public String excluir (@PathVariable long id,RedirectAttributes ra, Model model){
        ProdutoDao dao = new ProdutoDao();
         dao.excluir(id);
        ra.addFlashAttribute("mensagem","Excluido com sucesso");
        return "redirect:/produto";
}
    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String cadastro() {
    
       return "produto-new";
}
     @RequestMapping(value = "/pesquisa", method = RequestMethod.GET)
    public String pesquisaPorNome(@RequestParam String nome, Model model) {
    ProdutoDao dao = new ProdutoDao();
        model.addAttribute("dados", dao.pesquisaProdutos(nome));
       return "produtos";
    }
            @RequestMapping (value = "/addItem",method =RequestMethod.POST)
            public String logar (long idProduto,int quantidade,HttpSession sessao, Model model){
                List<ItemPedido> lista;
                if(sessao.getAttribute("carrinho")==null){
                    lista = new ArrayList<ItemPedido>();
                }else{
                    lista = (List<ItemPedido>)sessao.getAttribute("carrinho");                 
                }
                ProdutoDao dao = new ProdutoDao();
                ItemPedido item = new ItemPedido();
                item.setProduto(dao.produtoId(idProduto));
                item.setQuantidade(quantidade);
                boolean add = true;
                for(ItemPedido i : lista) {
                    if(i.getProduto().getId()==idProduto){
                        i.setQuantidade(quantidade);
                        add = false;
                    }
                }
                if (add) lista.add(item);
               //subtotal
                double subtotal = 0;
                for(ItemPedido i : lista){
                    subtotal += i.getProduto().getPreco() * i.getQuantidade();
                }
                sessao.setAttribute("total", subtotal);
                //fim subtotal
                sessao.setAttribute("carrinho", lista);
                return "redirect:/produto";
                
            }
            @RequestMapping(value = "/carrinho",method= RequestMethod.GET)
            public String carrinho(){
                return "carrinho";
            }
            @RequestMapping(value = "/removeItem/{id}", method = RequestMethod.GET)
            public String addItem(@PathVariable long id,HttpSession sessao,Model model){
                return "redirect:/produto/carrinho";
            }
    }
    
