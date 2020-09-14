<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<meta charset="ISO-8859-1">
<title>Assign Student to class</title>
</head>
<body>
${selectStudent}
${selectClass}
<a hreft=""><button type="button" name="addStudentToClass">Save</button></a>
</body>
</html>