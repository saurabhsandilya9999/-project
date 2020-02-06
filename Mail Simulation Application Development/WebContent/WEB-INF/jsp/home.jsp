<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1 align="center">Mail Info</h1>
<b >${data.getUmail() }<b>
<br>
<h4>${msg }</h4>
<hr>
<div style="text-align:center">
<form >
<button><a href="inbox">Inbox</a></button> 
<button><a href="draft">Draft</a></button> 
<button><a href="sent">Sent</a></button> 
<button><a href="delete">Delete</a></button> 
<button><a href="compose">Compose</a></button> 
<button><a href="logoutmail">Log Out</a></button>
<button><a href="change">Change Password</a></button>
</form>
</div>

</body>
</html>