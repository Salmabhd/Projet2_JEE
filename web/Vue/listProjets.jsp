<%@page import="Model.Projet"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Projets</title>
</head>
<body>

<h2>Liste des Projets</h2>

<table border="1">
    <tr>
        <th>ID Projet</th>
        <th>Nom Projet</th>
        <th>Date Début</th>
        <th>Date Fin</th>
        <th>Membres de l'Équipe</th>
        <th>État</th>
        <th>ID du Responsable</th>
    </tr>
    
    <c:forEach items="${PROJET_LIST}" var="projet">
        <tr>
            <td>${projet.projet_id}</td>
            <td>${projet.project_name}</td>
            <td>${projet.DateDebut}</td>
            <td>${projet.DateFin}</td>
            <td>${projet.MembresEquipe}</td>
            <td>${projet.etat}</td>
            <td>${projet.project_manager_id}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
