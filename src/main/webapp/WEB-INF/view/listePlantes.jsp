<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Plantes</title>
</head>
<body>
<div class="container">
<div class="card">
 <h1 class="text-center">
 Liste des plantes
 </h1>
 <div class="card-body">

 <table class="table table-striped">
 <tr>
<th>ID</th><th>Nom de la plante</th><th>couleur de la plante</th><th>Prix</th><th>Date
de vente</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${plantes}" var="p">
 <tr>
 <td>${p.idPlante }</td>
 <td>${p.nomPlante }</td>
 <td>${p.couleurPlante }</td>
 <td>${p.prix }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy"
value="${p.dateVente}" /></td>
 <td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerPlante?id=${p.idPlante }">Supprimer</a></td>
 <td><a href="modifierPlante?id=${p.idPlante }">Edit</a></td>
 </tr>
 </c:forEach>
 </table>
 </div>
</div>
</div>
</body>
</html>