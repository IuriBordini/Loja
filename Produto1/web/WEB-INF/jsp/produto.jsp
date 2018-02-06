<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Visualização de Produto</title>
        <jsp:include page="include/recursos.jsp"></jsp:include>
    </head>
    <body>

        <jsp:include page="include/menu.jsp"></jsp:include>
            <div class="container" id="conteudo">
                <section class="col-md-12">

                <c:if test="${not empty mensagem}">
                    <p class="alert alert-warning">${mensagem}</p>
                </c:if>
                <form class="form-horizontal" action="/loja/produto/atualizar" method="POST">
                    <input type="hidden" name="id" id="id" value="${produto.id}">
                    <fieldset>

                        <!-- Form Name -->
                        <legend>Visualização de Produto</legend>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="nome">Nome</label>  
                            <div class="col-md-4">
                                <input value="${produto.nome}" id="nome" name="nome" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="preco">Preço</label>  
                            <div class="col-md-4">
                                <input value="${produto.preco}" id="preco" name="preco" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="descricao">Descrição</label>  
                            <div class="col-md-4">
                                <input value="${produto.descricao}" id="descricao" name="descricao" type="text" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>

                        <!-- Text input-->
                      

                        <!-- Button -->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="botao"></label>
                            <div class="col-md-4">
                                <button id="botao" name="botao" class="btn btn-primary">Atualizar</button>
                            </div>
                        </div>

                    </fieldset>
                </form>  
                                        <form class="form-horizontal" action="/loja/produto/addItem" method="POST">
                    <input type="hidden" name="idProduto" id="idProduto" value="${produto.id}">
                     <!-- Text input-->
                        <div class="form-group">
                            <label class="col-md-4 control-label" for="Quantidade">Quantidade</label>  
                            <div class="col-md-4">
                                <input value="1" id="quantidade" name="quantidade" type="number" placeholder="" class="form-control input-md" required="">

                            </div>
                        </div>
                     <div class="form-group">
                            <label class="col-md-4 control-label" for="botao"></label>
                            <div class="col-md-4">
                                <button id="botao" name="botao" class="btn btn-primary">Adicinar</button>
                            </div>
                        </div>
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
