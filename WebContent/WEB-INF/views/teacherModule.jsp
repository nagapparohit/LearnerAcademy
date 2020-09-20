<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"	href='<c:url value="/resources/login.css"></c:url>'>
<title>Teacher Module</title>
</head>
<body>
<h2 class="innerModule">Logged In: ${username}</h2>
<p class="notAnAdmin">Welcome to Teacher Module</p>
	<div class="signup_form">
		<form action="saveTeacher" method="post">
			<input type="text" name="name" placeholder="Enter name"><br><br>
			<input type="text" name="contactNo" placeholder="Enter contact no"><br><br>
			<input type="submit" name="Submit"><br><br>
	        <a href="logout"><button type="button" name="logout">Logout</button></a><br><br>
			<a href="login"><button type="button" name="home">Home</button></a>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
</body>
</html>