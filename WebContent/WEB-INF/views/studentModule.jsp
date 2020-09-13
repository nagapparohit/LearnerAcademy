<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>Student Module</title>
</head>
<body>
<h2>Hi ${username}</h2>
	<a href="logout"><button type="button" name="logout">Logout</button></a>
	<a href="login"><button type="button" name="home">Home</button></a>
<a href="addStudent"><button type="button" name="addStudent">Add student</button></a><br><br>

<a href="checkStudent"><button type="button" name="checkStudent">check student</button></a><br><br>




<span>${error}</span>
</body>
</html>