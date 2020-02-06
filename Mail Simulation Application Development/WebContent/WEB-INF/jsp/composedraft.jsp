<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg }
<center>
<h2 style="text-align:center">Compose Message</h2><hr><br>
<button><a href="home">Home</a></button>
<button><a href="inbox">Inbox</a></button> 
<button><a href="sent">Sent</a></button>  
<button><a href="compose">Compose</a></button> 
<button><a href="logoutmail">Log Out</a></button><br><br>
<fieldset style="width:400px">
<form action="composeDraft" method="post">
<br>
To  <input type="text" name="to" placeholder=" Enter Email" size=25 value="${dto.getTomail() }"><br><br>
Subject  <input type="text" name="subject" placeholder=" Enter Subject" size=21 value="${dto.getSubject() }"><br><br>
Message  <input type="text" name="message" placeholder="    Text Here" style="height:100px" value="${dto.getMessage() }"><br><br><br>
<input type="submit" value="Send">
</form>
</fieldset>
</center>
</body>
</html>