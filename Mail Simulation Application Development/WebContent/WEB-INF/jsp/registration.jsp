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
<h2 style="text-align:center">Registration</h2><hr>
<h4>${dto}</h4>
<form action="registrationData" method="post">
<center>
<fieldset style="width:300px">
<pre style="text-align:center">
Name<input type="text" name="username" size=28 placeholder="Enter Name"><br>
Email<input type="text" name="umail" size=27 placeholder="Enter Email"><br>
Password<input type="password" name="password" placeholder="Enter Password" size=24><br>
Question  <select name="question" >
               <option>What is your pet name?</option>
               <option>What is your nick name?</option>
               <option>What is your fevorite book?</option>
          </select><br>
  Answer <input type="text" name="answer" placeholder="Your Answer" size=25>  <br>        
<input type="submit" value="SignUp">
<br>
<button><a href="login">Login</a></button>
</pre>
</fieldset>
</center>
</form>
</body>
</html>