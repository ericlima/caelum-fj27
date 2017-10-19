<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>${product.title}</title>

<c:url value="/" var="contextPath" />

<link rel="icon"
	href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979"
	type="image/ico" />
<link href="https://plus.googlecom/108540024862647200608"
	rel="publisher" />
<link href="${contextPath}resources/css/cssbase-min.css"
	rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' />
<link href="${contextPath}resources/css/fonts.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-ie7.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello-embedded.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/fontello.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/style.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="${contextPath}resources/css/layout-colors.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/responsive-style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/guia-do-programador-style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="${contextPath}resources/css/produtos.css" rel="stylesheet"
	type="text/css" media="all" />
<link rel="canonical" href="http://www.casadocodigo.com.br/" />
</head>
<body>

	<div>${msg}</div>

	<div>
		Seu carrinho (${shoppingCart.quantity})<br />
	</div>

	<table>

		<tr>
			<th>titulo</th>
			<th>preços</th>

			<c:forEach items="${livro.precos}" var="preco">
				<th align="right">${preco.tipo}</th>
			</c:forEach>

		</tr>

		<c:forEach items="${livros}" var="livro">

			<tr>
				<td><a href="/casadocodigo/livros/${livro.id}">${livro.titulo}</a></td>


				<c:forEach items="${livro.precos}" var="preco">
					<td>${preco.valor}</td>
				</c:forEach>

			</tr>

		</c:forEach>

	</table>

	<br />
	<form:form action="/casadocodigo/carrinho/checkout" method="post">
		<input type="submit" value="Checkout">
	</form:form>

	<sec:authorize access="hasRole('ADMIN')">
		<c:url value="/products/form" var="cadastro"/>
		<a href="${cadastro}">Cadastrar Livro</a>
	</sec:authorize>
	

</body>
</html>