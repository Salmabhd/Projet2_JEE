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
<form action="../AjoutProjet" method="post">
    <center><!-- comment -->
    <label class="formbold-form-label formbold-form-label-2">
            <h4> Creer un nouveau projet<!-- comment --></h4>
      </label></center>
    
      <div class="formbold-mb-5">
        <label for="nom" class="formbold-form-label">Nom du Projet: </label>
        <input
          type="text"
          name="project_name"
          id="project_name"
          placeholder="Entrez le nom du projet"
          class="formbold-form-input"
        />
      </div>
     <div class="flex flex-wrap formbold--mx-3">
        <div class="w-full sm:w-half formbold-px-3">
          <div class="formbold-mb-5 w-full">
            <label for="dateD" class="formbold-form-label"> Date de Debut: </label>
            <input
              type="date"
              name="date_debut"
              id="date_debut"
              class="formbold-form-input"
            />
          </div>
        </div>
        <div class="w-full sm:w-half formbold-px-3">
          <div class="formbold-mb-5">
            <label for="dateF" class="formbold-form-label"> Date de Fin: </label>
            <input
              type="date"
              name="date_fin"
              id="date_fin"
              class="formbold-form-input"
            />
          </div>
        </div>
      </div>
    
      <div class="formbold-mb-5">
        <label for="membres_equipe" class="formbold-form-label"> Membres de l'Equipe: </label>
        <input
          type="text"
          name="membres_equipe"
          id="membres_equipe"
          placeholder="Entez les membres d'equipe du projet"
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
              name="project_manager_id"
              id="project_manager_id"
              class="formbold-form-input"
            />
          </div>
        </div>
      </div>
    
    
    
     

      <div>
        <button class="formbold-btn">Ajouter le projet</button>
      </div>
    </form>
  </div>
</div>
       
</body><!-- comment -->
</html>