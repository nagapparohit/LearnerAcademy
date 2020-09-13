<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>Subject</title>
</head>
<body>

<h2>Hi ${username}</h2>
	<a href="logout"><button type="button" name="logout">Logout</button></a>
	<a href="login"><button type="button" name="home">Home</button></a>
	<div class="login_form">
		<form action="saveSubject" method="post">
			<input type="text" name="name" placeholder="Enter name"><br><br>
			<input type="text" name="code" placeholder="Enter code"><br><br>
			<input type="submit" name="Submit"><br><br>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
</body>
</html>