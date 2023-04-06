<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="windows-1256">
    <title>Modifier un Produit</title>
</head>
<body>
<form action="updateStudent" method="post">
<pre>
id : <input type="text" name="id" value="${student.id}">
name :<input type="text" name="name" value="${student.name}">
mail :<input type="text" name="email" value="${student.email}">
password :<input type="text" name="password" value="${student.password}">
<input type="submit" value="Modifier">
</pre>
</form>
<br/>
<br/>
<a href="listeStudents">Liste Students</a>
</body>
</html>