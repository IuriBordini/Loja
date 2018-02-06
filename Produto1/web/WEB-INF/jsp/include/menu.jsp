
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/loja/produto">LOJA</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/loja/produto/cadastro">Novo Produto</a></li>
        <li><a href="/loja/produto/">Lista de  produtos</a></li>
        <li><a href="/loja/sair">${funcionario} | Sair</a></li>
        <li><a href="/loja/produto/carrinho"> ${fn:length(carrinho)}   Itens</a></li>
      </ul>
      <form class="navbar-form navbar-right "action="/loja/produto/pesquisa"method ="GET">
        <div class="form-group">
          <input name="nome" id="nome" type="text" class="form-control" placeholder="Pesquisa">
        </div>
        <button type="submit" class="btn btn-default">Ok</button>
      </form>

    </div>
  </div>
</nav>
