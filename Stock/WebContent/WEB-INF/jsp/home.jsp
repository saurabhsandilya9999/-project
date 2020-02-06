<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: yellow;
}
</style>
<body>
<div align="center">
<h1>Home Page</h1>
</div>
<hr><br><br>
<div align="center">
<form action="search" method="post">
<input type="search" name="search">
<input type="submit" value="search">
</form>
<h3 align="center">
<button><a href="addpro">Add Product</a></button>
<button><a href="modyproduct">Products</a></button>
</h3>
</div>
</body><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<marquee behavior="alternate" direction="left" >*****Welcome to Stock Management Application*****</marquee>
</html>