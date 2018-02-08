<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Produtos</title>
        <jsp:include page="include/recursos.jsp"></jsp:include>
    </head>
    <body>

        <jsp:include page="include/menu.jsp"></jsp:include>
        <div class="container" id="conteudo">
            <section class="col-md-12">
           
            <c:if test="${not empty mensagem}">
                <p class="alert alert-warning">${mensagem}</p>
            </c:if>
            
            <h1>Lista de usuarios</h1>

            
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>NOME</th>
                    <th>Senha</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="produto"  items="${dados}">
                    <tr>
                        <td>${usuario.id}</td>
                        <td>${usuario.nome}</td>
                        
                        <td>${usuario.descricao}</td>
                        <td><a href="/loja/usuario/${usuario.id}">Visualizar</a></td>
                        <td><a href="/loja/usuario/excluir/${usuario.id}">Excluir</a></td>
                    </tr>
                    
                </c:forEach>
            </table>


            </section>

        </div>
        <footer id="rodape">
            <div class="container">
                <p>Rodapé</p>
            </div>        
        </footer>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>


  