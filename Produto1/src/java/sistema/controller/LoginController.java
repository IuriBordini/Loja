
package sistema.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/logar",method =RequestMethod.POST)
    public String logar (HttpSession sessao){
        sessao.setAttribute("funcionario", "Iuri");
        
        return "redirect:/produto";
    }
     @RequestMapping(value = "/sair",method =RequestMethod.GET)
    public String sair (HttpSession sessao){
        sessao.invalidate();
        return "login";
    }
    
}
