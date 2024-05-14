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
    
    <% for (Projet projet : (List<Projet>) request.getAttribute("PROJET_LIST")) { %>
        <tr>
            <td><%= projet.getProjet_id() %></td>
            <td><%= projet.getProject_name() %></td>
            <td><%= projet.getDateDebut() %></td>
            <td><%= projet.getDateFin() %></td>
            <td><%= projet.getMembresEquipe() %></td>
            <td><%= projet.getEtat() %></td>
            <td><%= projet.getProject_manager_id() %></td>
        </tr>
    <% } %>
</table>

</body>
</html>
