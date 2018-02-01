<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login</title>
        <jsp:include page="include/recursos.jsp"></jsp:include>
    </head>
    <body>

        
            <div class="container" id="conteudo">
                <section class="col-md-12">

                <c:if test="${not empty mensagem}">
                    <p class="alert alert-warning">${mensagem}</p>
                </c:if>
                <form class="form-horizontal" action="/loja/logar" method="POST">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Login</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="login">Login</label>  
                            <div class="col-md-4">
                                <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="senha">Senha</label>  
                            <div class="col-md-4">
                                <input id="senha" name="senha" type="password" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                       

                        <!-- Text input-->
                      

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="botao"></label>
                            <div class="col-md-4">
                                <button id="botao" name="botao" class="btn btn-primary">Logar</button>
                            </div>
                        </div>

                    </fieldset>
                </form>  


            </section>

        </div>
        <footer id="rodape">
            <div class="container">
                <p>Loja</p>
            </div>        
        </footer>


    </body>
</html>
