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
            
            <h1>Carrinho de Compras</h1>

            
            <table class="table">
                <tr>
                    <th>ID</th>
                    <th>NOME</th>
                    <th>PREÇO</th>
                    <th>DESCRIÇÃO</th>
                    <th>Quantidade</th>
                    <th></th>
                     <th></th>
                </tr>
                <c:forEach var="carrinho"  items="${carrinho}">
                    <tr>
                        <td>${carrinho.produto.id}</td>
                        <td>${carrinho.produto.nome}</td>
                        <td>${carrinho.produto.preco}</td>
                        <td>${carrinho.produto.descricao}</td>
                        <td>${carrinho.quantidade}</td>
                        <td><a href="/loja/produto/${carrinho.produto.id}">Alterar</a></td>
                        <td><a href="/loja/produto/removeItem/${carrinho.produto.id}">Excluir</a></td>
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
