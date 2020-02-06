<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: orange;
}
</style>
<body>
<div align="center">
<h1>Stock</h1>
</div>
<div align="right" style="color: green">${success }</div>
<div align="right" style="color: red">${failed }</div>
<hr>
<center>
<button><a href="addpro">add product</a></button>
<button><a href="modyproduct">Modify Product</a></button>
<button><a href="home">home page</a></button>
</center>
<hr>
</body>
</html>