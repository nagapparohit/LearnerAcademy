<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<form class="login_form" action="login" method="post">
		<input type="text" name="username" placeholder="Enter Username" ><br><br>
		<input type="password" name="password" placeholder="Enter password"><br><br>
		<input type="submit"  value="submit" >
		<a href="signup"><button type="button" name="signup">Sign up</button></a> <br><br>
		<a href="forget_password"><button type="button" name="forget_password">Forget Password</button></a>
	</form>
	<span>${invalidCredentials}</span>


</body>
</html>
