<%@ page language="java" contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ${spring:mvcUrl('LC#salvar').build()} -->
	<form:form action="/casadocodigo/livros" method="post" commandName="livro" enctype="multipart/form-data" > 

		<div>
		
		<label>Titulo</label> 
		<form:input path="titulo" id="titulo" /> 
		<form:errors path="titulo" />
		</div>
		
		<div>
		<label>Descricao</label>
		<form:input path="descricao" />
		<form:errors path="descricao" />
		</div>

		<div>
		<label>Paginas</label> 
		<form:input path="paginas" />
		<form:errors path="paginas" />
		</div>
		
		<div>
		<label>Data Lançamento</label> 
		<input type="date" name="dataLancamento" />
		<form:errors path="dataLancamento" />
		</div>
		
		<div>
		<label>Sumario</label> 
		<input type="file" name="sumario" />
		</div>
		
		<div>
			<c:forEach items="${types}" varStatus="status" var="bookType">
				<div>
					<label>${bookType}</label> 
					<input type="hidden" name="precos[${status.index }].tipo"   value="${bookType }" /> 
					<form:input path="precos[${status.index }].valor" />
				</div>
			</c:forEach>
		</div>

		<input type="submit" value="Salvar" /> <label> </label>
	</form:form>

</body>
</html>