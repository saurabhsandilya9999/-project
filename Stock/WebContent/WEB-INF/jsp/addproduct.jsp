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
<div align="center"><br><br>
<h1>Enter Product Details</h1>
<fieldset>
<style>
fieldset{
width: 350px;
height: 270px;
}
</style>

<form action="addproduct" method="post">
<pre>
Product Name: <input type="text" name="pName" placeholder="Enter Product"><br>
Category:     <select name="category" style="width: 170px">
               <option>Select</option>
               <option>Toys</option>
               <option>Cloths</option>
               <option>Food</option>
               <option>Cosmetics</option>
               <option>Sports</option>
          </select><br>
Company:      <input type="text" name="cName" placeholder="Company Name"><br>
Quantity:     <input type="number" name="quantity" placeholder="Enter Quantity"><br>
Price:        <input type="number" name="price" placeholder="Enter Price"><br>
<input type="submit" value="submit"><br>
<button><a href="modyproduct">Modify Product</a></button>   <button><a href="home">Home</a></button>
</pre>
</form>
</fieldset>
</div>
</body>
</html>