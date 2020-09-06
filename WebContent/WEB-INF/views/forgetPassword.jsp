<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>Forgot Password</title>
</head>
<body>

	<div class="forgetPassword_form">
		<form action="newPassword" method="post">
			<input type="text" name="username" placeholder="type Username"><br><br>
			<input type="password" name="password" placeholder="type new password"><br><br>
			<input type="submit" value="submit">
			<a href="/LearnerAcademy-0.0.1-SNAPSHOT/"><button type="button" name="home">Home</button></a>
		</form>
    
		<span>${usernotexist}</span>
	</div>
</body>
</html>
