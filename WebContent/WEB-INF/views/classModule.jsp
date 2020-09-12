<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class</title>
</head>
<body>


	<div class="login_form">
		<form action="saveClass" method="post">
			<input type="text" name="section" placeholder="Enter Section"><br><br>
			<input type="text" name="value" placeholder="Enter Standard"><br><br>
			<input type="submit" name="Submit"><br><br>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
</body>
</html>