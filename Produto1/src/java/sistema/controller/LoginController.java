
package sistema.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sistema.modelo.Usuario;
import sistema.modelo.UsuarioDao;

@Controller

public class LoginController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/logar",method = RequestMethod.POST)
    public String logar (Usuario usuario , RedirectAttributes ra, HttpSession sessao){
        UsuarioDao dao = new UsuarioDao();
        if(dao.existe(usuario)){
            sessao.setAttribute("funcionario", usuario.getNome());
            return "redirect:/produto";
                    
        }else{
            ra.addFlashAttribute("mensagem","usuario invalodo");
            sessao.invalidate();
            return"redirect:/"  ;
            
        }
        
        
        
    }
     @RequestMapping(value = "/sair",method =RequestMethod.GET)
    public String sair (HttpSession sessao){
        sessao.invalidate();
        return "login";
    }
    
}
