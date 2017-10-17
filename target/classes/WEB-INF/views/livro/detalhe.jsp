<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div>
		Seu carrinho (${shoppingCart.quantity})
		</div>

		<div>
		<label>Titulo</label> 
		<label>${livro.titulo}</label>
		</div>
		
		<div>
		<label>Descricao</label>
		<label>${livro.descricao}</label>
		</div>

		<div>
		<label>Paginas</label> 
		<label>${livro.paginas}</label>
		</div>
		
		<div>
		<label>Data Lançamento</label> 
		<label><fmt:formatDate type = "date" 
         value = "${livro.dataLancamento.time}" /></label>
		</div>
		
		<form action="/casadocodigo/carrinho" method="post" class="container">
				<input type="hidden" value="${livro.id}" name="id"/>
				<ul id="variants" class="clearfix">
					<c:forEach items="${livro.precos}" var="preco">
						<li class="buy-option">
							<input type="radio" name="tipo" class="variant-radio" id="${livro.id}-${preco.tipo}"
								value="${preco.tipo}" >
							 
							<label class="variant-label" for="${livro.id}-${preco.tipo}"> 
								${preco.tipo}
							</label>
							<p class="variant-price">${preco.valor}</p>
						</li>
					</c:forEach>
				</ul>

				<input type="submit" class="submit-image icon-basket-alt" alt="Compre agora" title="Compre agora '${livro.titulo}'!" value="comprar"/>
		</form>	
		
		
		
		
		<a href="/casadocodigo/livros" >Voltar</a>
</body>
</html>