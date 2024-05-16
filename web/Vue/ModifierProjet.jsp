

<%@page import="Model.Projet"%>

<%@page import="java.sql.*" %> 
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel="stylesheet" href="css/ajouterProjet.css">
    </head>
    <body>
        <div class="formbold-main-wrapper">
  <!-- Author: FormBold Team -->
  <!-- Learn More: https://formbold.com -->
  <div class="formbold-form-wrapper">
      <h1>Modifier Projet</h1>
   
    <% Projet projet = (Projet) request.getAttribute("projet"); %>
    
    <form action="../ModifierProjet" method="post">
    <center><!-- comment -->
    <label class="formbold-form-label formbold-form-label-2">
            <h4> Creer un nouveau projet<!-- comment --></h4>
      </label></center>
    
        <div class="formbold-mb-5">
        <label for="nom" class="formbold-form-label">ID du Projet: </label>
         <input type="text" name="projet_id" value="<%= projet.getProjet_id() %>">
      </div>
        
               

      <div class="formbold-mb-5">
        <label for="nom" class="formbold-form-label">Nom du Projet: </label>
        <input
          type="text"
          id="project_name" name="project_name" value="<%= projet.getProject_name() %>"
          class="formbold-form-input"
        />
      </div>
     <div class="flex flex-wrap formbold--mx-3">
        <div class="w-full sm:w-half formbold-px-3">
          <div class="formbold-mb-5 w-full">
            <label for="dateD" class="formbold-form-label"> Date de Debut: </label>
            <input
              type="date"
              id="date_debut" name="date_debut" value="<%= projet.getDateDebut() %>"
              class="formbold-form-input"
            />
          </div>
        </div>
        <div class="w-full sm:w-half formbold-px-3">
          <div class="formbold-mb-5">
            <label for="dateF" class="formbold-form-label"> Date de Fin: </label>
            <input
              type="date"
              id="date_fin" name="date_fin" value="<%= projet.getDateFin() %>
              class="formbold-form-input"
            />
          </div>
        </div>
      </div>
    
      <div class="formbold-mb-5">
        <label for="membres_equipe" class="formbold-form-label"> Membres de l'Equipe: </label>
        <input
          type="text"
          id="membres_equipe" name="membres_equipe" value="<%= projet.getMembresEquipe() %>"
          class="formbold-form-input"
        />
      </div>
    
     <div class="flex flex-wrap formbold--mx-3">
        <div class="w-full sm:w-half formbold-px-3">
          <div class="formbold-mb-5 w-full">
            <label for="etat" class="formbold-form-label"> Etat: </label>
            <select id="etat" name="etat" required>
        <option value="En cours">En cours</option>
        <option value="Terminé">Terminé</option>
        <option value="En attente">En attente</option>
    </select>
          </div>
        </div>
        <div class="w-full sm:w-half formbold-px-3">
          <div class="formbold-mb-5">
            <label for="project_manager_id" class="formbold-form-label"> ID chef du projet: </label>
            <input
              type="number"
              id="project_manager_id" name="project_manager_id" value="<%= projet.getProject_manager_id() %>
              class="formbold-form-input"
            />
          </div>
        </div>
      </div>
    
    
    
     

      <div>
        <button class="formbold-btn">Enregistrer les Modifications</button>
      </div>
    </form>
  </div>
</div>
       
</body><!-- comment -->
</html>






