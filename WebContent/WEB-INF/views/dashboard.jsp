<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>dashboard</title>
</head>
<body>


<h1>This is dashboard you will reach here after login url wiht ${somekey}. Hi ! ${username} , ${password}, ${isAdmin}</h1>

	<a href="logout"><button type="button" name="logout">Logout</button></a>
	
<a href="studentModule"><button type="button" name="student_module">student module</button></a><br><br>

<a href="classModule"><button type="button" name="class_module">class module</button></a><br><br>

<a href="teacherModule"><button type="button" name="teacher_module">teacher module</button></a><br><br>

<a href="subjectModule"><button type="button" name="subject_module">subject module</button></a><br><br>

<a href="assignS2C"><button type="button" name="assignStudentTOClasses">Assign student to classes</button></a>

<a href="assignTS2C"><button type="button" name="assignTS2C">Assign subject and teacher to a class</button></a>

</body>
</html>
