<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<meta charset="ISO-8859-1">
<title>Assing teacher and sub</title>
</head>
<body>
<form action="saveTS2C" method="post">
${teacherList}
${subjectList}
${classList}
<input type="submit" name="addTeacherSubjectToClass" value="Save">
<a href="login"><button type="button" name="home">Home</button></a>
${successSaved}
</form>
</body>
</html>