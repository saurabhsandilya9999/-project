<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<br>
<h2 style="text-align:center">Login Page</h2><br><hr><br>
${msg}<center>
<fieldset style="width:300px">
<form action="loginValidation" method="post">
<div style="text-align:center">
<br>
Email:   <input type="email" name="umail" placeholder="Enter Email" size=15><br><br>
Password:<input type="password" name="password" placeholder="Enter Password" size=12><br><br>

<input type="submit" value="Login"><br><br>
<button><a href="registration">Registration</a></button>  <button><a href="forget">Forget Password</a></button>
</div>
</form>
</fieldset></center>
</body>
</html>