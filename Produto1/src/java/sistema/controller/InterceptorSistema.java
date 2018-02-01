package sistema.controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class InterceptorSistema  extends HandlerInterceptorAdapter{

//1º passo
    
	public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, 
                Object controller) throws Exception{
		
		String url = request.getRequestURI();
		// Páginas permitidas para acesso sem login 
		if(
                                url.endsWith("/loja/")
				|| url.endsWith("/logar")
                        	|| url.contains("resource")
                                
                                )
		{
			return true;
		}
		// Verificando se o usuário está logado na session
		if(request.getSession().getAttribute("funcionario") !=null){
			return true; // Permite
		}else{
			request.getRequestDispatcher("/").forward(request, response);
			return false; // Não permitir, redireciona para login
		}
	}    
}
