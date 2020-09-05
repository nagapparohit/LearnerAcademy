<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>Sign Up</title>
</head>
<body>
	<div class="signup_form">
		<form action="register" method="post">
			<input type="text" name="username" placeholder="Create Username"><br><br> 
			<input type="password" name="password" placeholder="Create password"><br><br> 
			<input type="submit" value="submit"> 
		</form>
		<span>${alreadyExists}</span>
	</div>

</body>
</html>