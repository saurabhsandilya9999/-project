<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Forget Page</h1>
</center>
<center>
<fieldset style="width:300px">
<form action="forgetPass" method="post"><br><br>
   Email <input type="email" name="umail" placeholder="Enter Email" size=25><br><br>
   Question <select name="question">
               <option>What is your pet name?</option>
               <option>What is your nick name?</option>
               <option>What is your fevorite book?</option>
          </select><br><br>
   Answer <input type="text" name="answer" placeholder="Enter Answer" size="24"><br><br>
   Password <input type="password" name="pass" placeholder="Enter new Password" size=22><br><br>
   Confirm Password <input type="password" name="cpass" placeholder="Confirm Password" size=14><br><br>
   <input type="submit" value="submit">
   </form>
        <h4> ${msg } </h4>
</center>
</fieldset>
</body>
</html>