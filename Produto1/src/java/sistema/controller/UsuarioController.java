
package sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sistema.modelo.Usuario;
import sistema.modelo.UsuarioDao;

/**
 *
 * @author Familia
 */
@Controller
@RequestMapping ("/usuario")
public class UsuarioController {
    
                 @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar() {
    
       return "cadastro-usuario";
}
    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar (Usuario usuario , Model model){
        UsuarioDao dao = new UsuarioDao();
        dao.cadastrar(usuario);
        model.addAttribute("mensagem","Cadastrado com sucesso");
        return "cadastro-usuario";
    }
    public String listar (Usuario usuario , Model model){
       UsuarioDao dao = new UsuarioDao();
        
        model.addAttribute("dados", dao.getUsuario());
        return "usuarios";
    }
}
