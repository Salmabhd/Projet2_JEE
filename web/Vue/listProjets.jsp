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
<form method="post" action="ajoutlist.jsp">
    <button type="submit">Ajouter un Projet</button>
</form>
</body>
</html>





   <section class="page-section portfolio" id="portfolio">
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0">Liste des projets</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Portfolio Grid Items-->
			<div class="row justify-content-center">
				 <table>
				<thead>
					<tr>
			                        <th>ID de projet</th>
						<th>Nom du projet</th>
						<th>Date de debut</th>
                                                <th>Date de fin</th>
						<th>Membres d'equipe</th>
						<th>etat</th>
                                                <th>chet de projet</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
                                     <c:forEach items="${PROJET_LIST}" var="projet">
            <tr>
            <td>${projet.projet_id}</td>
            <td>${projet.project_name}</td>
            <td>${projet.DateDebut}</td>
            <td>${projet.DateFin}</td>
            <td>${projet.MembresEquipe}</td>
            <td>${projet.etat}</td>
            <td>${projet.project_manager_id}</td>
            <td>
            <td>
            <form method="post" action="ProjetControllerServlet">
                <input type="hidden" name="projet_id" value="${projet.projet_id}" />
                <button type="submit" name="action" value="modifier" class="btn btn-primary">Modifier</button>
                <button type="submit" name="action" value="supprimer" class="btn btn-danger">Supprimer</button>
            </form>
            </td>
            </tr>
    </c:forEach>
				</tbody>
			</table>
				
			</div>
		</div>
	</section>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
	<!-- About Section-->
	<section class="page-section bg-primary text-white mb-0" id="about">
		<div class="container">
			<!-- About Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-white">Ajouter un projet</h2>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- About Section Content-->
			<div class="row">
				<div class="col-lg-4 ms-auto">
					<p class="lead">.</p>
				</div>
				<div class="col-lg-4 me-auto">
					<p class="lead"></p>
				</div>
			</div>
			<!-- About Section Button-->
			<div class="text-center mt-4">
				<a class="btn btn-xl btn-outline-light"
					href="ajouter.jsp"> <i
					class="fas fa-download me-2"></i> Ajouter
				</a>
			</div>
		</div>
	</section>