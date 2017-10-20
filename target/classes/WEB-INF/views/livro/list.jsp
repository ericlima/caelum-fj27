<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="cdc" %>

<cdc:page title="listagem de livros">

	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal" var="usuario"/><fmt:message key="ola"/> ${usuario.name}
	</sec:authorize>

	

	<div>${msg}</div>

	<div>
		<fmt:message key="carrinho"/> (${shoppingCart.quantity})<br />
	</div>

	<table>

		<tr>
			<th><fmt:message key="titulo"/></th>
			<th><fmt:message key="precos"/></th>

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
	
	<c:url value="/" var="contextPath" />
	
	<form:form ="${contextPath}/carrinho/checkout" method="post">
		<input type="submit" value="Checkout">
	</form:form>

	<sec:authorize access="hasRole('ADMIN')">
		<c:url value="/livros/form" var="cadastro"/>
		<a href="${cadastro}"><fmt:message key="cadastro"></fmt:message></a>
	</sec:authorize>
	
	
	
	<a href="${contextPath}/livros?locale=en_US">English</a>
	<a href="${contextPath}/livros?locale=pt_BR">Português</a>

</cdc:page>
