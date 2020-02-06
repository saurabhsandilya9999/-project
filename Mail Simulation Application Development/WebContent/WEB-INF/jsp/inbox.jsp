<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg }
<h1 style="text-align:center">Inbox Message</h1><br><br><hr><br>
<center>
<button><a href="home">Home</a></button>
<button><a href="sent">Sent</a></button> 
<button><a href="delete">Delete</a></button> 
<button><a href="compose">Compose</a></button> 
<button><a href="logoutmail">Log Out</a></button>
<br><br>
<table border="1" style="text-align:center;">
    <tr>
        <th>Mail by</th>
        <th>Message</th>
        <th>delete</th>
    </tr>
    <c:forEach var="dto" items="${list }">
    <tr>
        <td>${dto.getFrommail() }</td>
        <td>${dto.getMessage() }</td>
        <td><a href="deleteMail?id=+${dto.getMid() }+">delete</a></td>
    </tr>
    </c:forEach>
</table>
</center>
</body>
</html>


