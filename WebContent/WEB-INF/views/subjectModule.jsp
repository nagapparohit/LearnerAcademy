<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>
</head>
<body>

<h2>Hi ${username}</h2>
	<div class="login_form">
		<form action="saveSubject" method="post">
			<input type="text" name="name" placeholder="Enter name"><br><br>
			<input type="text" name="code" placeholder="Enter code"><br><br>
			<input type="submit" name="Submit"><br><br>
		</form>
		<span>${invalidCredentials}</span>
		<span>${error}</span>
	</div>
</body>
</html>