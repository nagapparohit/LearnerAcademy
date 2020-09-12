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

	<div class="login_form">
		<form action="saveTeacher" method="post">
			<input type="text" name="name" placeholder="Enter name"><br><br>
			<input type="text" name="contactNo" placeholder="Enter contact no"><br><br>
			<input type="submit" name="Submit"><br><br>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
</body>
</html>