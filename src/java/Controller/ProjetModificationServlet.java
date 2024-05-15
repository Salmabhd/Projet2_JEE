/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProjetDAO;
import Model.Projet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class ProjetModificationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        int projetId = Integer.parseInt(request.getParameter("projet_id"));
        String projectName = request.getParameter("project_name");
        String dateDebut = request.getParameter("date_debut");
        String dateFin = request.getParameter("date_fin");
        String membresEquipe = request.getParameter("membres_equipe");
        String etat = request.getParameter("etat");
        int projectManagerId = Integer.parseInt(request.getParameter("project_manager_id"));

        // Créer un objet Projet avec les nouvelles valeurs
        Projet updatedProjet = new Projet( projectName, dateDebut, dateFin, membresEquipe, etat, projectManagerId);

        // Mettre à jour le projet dans la base de données
        try {
            ProjetDAO projetDbUtil = new ProjetDAO();
            projetDbUtil.updateProjet(updatedProjet);
        } catch ( ClassNotFoundException e) {
            e.printStackTrace(); // Gérer les erreurs de manière appropriée
        } catch (SQLException ex) {
            Logger.getLogger(ProjetModificationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Rediriger vers une autre page après la mise à jour
        response.sendRedirect(request.getContextPath() + "/listProjet.jsp");
    }
}
