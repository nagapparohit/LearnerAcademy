<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>Home</title>
</head>
<body>
	<div class="login_form">
		<form action="login" method="post">
			<input type="text" name="username" placeholder="Enter Username"><br>
			<br> <input type="password" name="password" placeholder="Enter password"><br>
			<br> <input type="submit" value="submit"> 
			<a href="signup"><button type="button" name="signup">Sign up</button></a> <br><br> 
			
			<a href="forget_password"><button type="button" name="forget_password">Forget Password</button></a>
		</form>
		<span>${invalidCredentials}</span>
	</div>

</body>
</html>
