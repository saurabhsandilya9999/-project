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
<center>
<h1 style="text-align:center">Delete Page</h1><br><br><hr><br>
<button><a href="home">Home</a></button>
<button><a href="inbox">Inbox</a></button> 
<button><a href="sent">Sent</a></button>  
<button><a href="compose">Compose</a></button> 
<button><a href="logoutmail">Log Out</a></button><br><br>
<form action="deleteshow" method="post">

<table border="1px" style="text-align:center;">
    <tr>
        <th>Mail by</th>
        <th>Message</th>
        <th>delete</th>
    </tr>
    <c:forEach var="data" items="${list}">
    <tr>
        <td>${data.getTomail()}</td>
        <td>${data.getMessage()}</td>
        <td><a href="deleteshow?id=${data.getMid()}">delete</a></td>
    </tr>
    </c:forEach>
    </table>
</form>
</center>

</body>
</html>
     