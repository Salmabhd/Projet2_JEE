<%@ page language="java"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Créer un Projet</title>
</head>
<body>

<h2>Créer un Projet</h2>

<form action="<%= request.getContextPath() %>/AjoutProjet" method="post">
    <label for="project_name">Nom du Projet:</label>
    <input type="text" id="project_name" name="project_name" required><br><br>
    
    <label for="date_debut">Date de Début:</label>
    <input type="date" id="date_debut" name="date_debut" required><br><br>
    
    <label for="date_fin">Date de Fin:</label>
    <input type="date" id="date_fin" name="date_fin" required><br><br>
    
    <label for="membres_equipe">Membres de l'Équipe:</label>
    <input type="text" id="membres_equipe" name="membres_equipe"><br><br>
    
    <label for="etat">État:</label>
    <select id="etat" name="etat" required>
        <option value="En cours">En cours</option>
        <option value="Terminé">Terminé</option>
        <option value="En attente">En attente</option>
    </select><br><br>
    
    <label for="project_manager_id">ID du Responsable:</label>
    <input type="text" id="project_manager_id" name="project_manager_id" required><br><br>
    
    <input type="submit" value="Créer">
</form>

</body>
</html>
