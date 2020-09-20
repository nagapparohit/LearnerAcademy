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
<h1 style="text-align:center">Assign Subject to Teacher for a Class</h1>
<form action="saveTS2C" method="post">
<div class="selectTag1">
${teacherList}
${subjectList}
${classList}
</div>
	<div id="dashboard_nav">
		<ul>
			<li><input type="submit" name="addTeacherSubjectToClass" style="background: linear-gradient(skyblue,white);" value="Save"></li>
			<li><a href="login">Home</a></li>
		</ul>
	</div>

<!-- 
<input type="submit" name="addTeacherSubjectToClass" value="Save">
<a href="login"><button type="button" name="home">Home</button></a> -->
<h3 style="text-align:center">${successSaved}</h3>
</form>
</body>
</html>