
package sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sistema.modelo.Produto;

import sistema.modelo.ProdutoDao;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String produtos(Model model){
        ProdutoDao dao = new ProdutoDao();
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
    }
    
