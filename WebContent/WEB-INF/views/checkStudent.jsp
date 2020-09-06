<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check Student</title>
</head>
<body>

	<div class="login_form">
		<form action="getStudent" method="post">
			<input type="text" name="admNo" placeholder="Enter Admission No"><br><br>
			<input type="submit" name="Submit"><br><br>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
</body>
</html>