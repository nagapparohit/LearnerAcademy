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

<h1>This is dashboard you will reach here after login url wiht ${somekey}. Hi ! ${username} , ${password}</h1>
<table class="modulesTable">
  <tr>
    <div class="studentModule"><td>student module</td></div>
    <div class="classModule"><td>class module</td></div>
  </tr>
  <tr>
    <div class="subjectModule"><td>subject module</td></div>
    <div class="teacherModule"><td>teacher module</td></div>
  </tr>
</table>
</body>
</html>
