<%@ page language="java" contentType="text/html;charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<!-- ${spring:mvcUrl('LC#salvar').build()} -->
	<form:form servletRelativeAction="/login" method="post"  > 

		<div>
		
		<label>Usuario</label> 
		<input name="username" /> 
		</div>
		
		<div>
		<label>Senha</label>
		<input type="password" name="password"  />
		</div>

		<input type="submit" value="Login" /> <label> </label>
		
	</form:form>

</body>
</html>