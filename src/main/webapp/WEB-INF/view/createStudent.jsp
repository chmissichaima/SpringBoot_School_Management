<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 05/04/2023
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"
      href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<head>
    <meta  http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Add Student</title>
</head>
<body>
<div class="container">
    <div class="card-body">
<form action="saveStudent" method="post">
    <h1>Add Student <i class="bi bi-person-plus-fill"></i></h1>
    <div class="form-group">
        <label class="control-label">Nom Produit :</label>

 <input type="text" name="name"  class="form-control">
    </div>
    <div class="form-group">
        <label class="control-label">Email :</label>
 <input type="text" name="email" class="form-control">
    </div>
    <div class="form-group">
        <label class="control-label">date création :</label>

 <input type="password" name="password" class="form-control">
        <button type="submit" class="btn btn-primary">Ajouter</button>

    </div>


</form>

    </div>

${msg}
<br/>
<br/>
<a href="listeStudents">Liste Student</a>
</div>
</body>
</html>
