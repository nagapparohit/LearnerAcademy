<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/login.css"></c:url>'>
<title>Add Student Form</title>
</head>
<body>

	<div class="login_form">
		<form action="saveStudent" method="post">
			<input type="text" name="admNo" placeholder="Enter Admission No"><br><br>
			<input type="text" name="address" placeholder="Enter Address No"><br><br>
			<input type="text" name="contactNo" placeholder="Enter Mobile No"><br><br>
			<input type="text" name="fname" placeholder="Enter first name"><br><br>
			<input type="text" name="lname" placeholder="Enter last name"><br><br>
			<input type="text" name="rollNo" placeholder="Enter Roll No"><br><br>
			<input type="submit" name="Submit"><br><br>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
	
</body>
</html>