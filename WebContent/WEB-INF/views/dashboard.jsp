<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/login.css"></c:url>'>
<title>dashboard</title>
</head>
<body>


	<%-- <h1>This is dashboard you will reach here after login url wiht ${somekey}. Hi ! 
${username} , ${password}, ${isAdmin}</h1> --%>

	<span class="welcomeUser">Welcome ${username}</span>
	<span class="logoutButton"><a href="logout">Logout</a></span>
	<p class="notAnAdmin">${notAnAdmin}</p>
	<div id="dashboard_nav">
		<ul>
			<li><a href="studentModule" >student module</a></li>
			<li><a href="classModule" >class module</a></li>
			<li><a href="teacherModule" >teacher module</a></li>
			<li><a href="subjectModule" >subject module</a></li>
			<li><a href="assignS2C" >Assign Stu to class</a></li>
			<li><a href="assignTS2C" >Assign Sub &amp; Teach</a></li>
		</ul>
	</div>
	${classesDiv}
</body>
</html>
