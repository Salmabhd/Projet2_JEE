package Controller;

import Model.Projet;
import DAO.ProjetDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifierProjet")
public class ProjetModificationServlet extends HttpServlet {
        private ProjetDAO projetDao;


 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Récupérer l'ID du projet depuis les paramètres de requête
    int projetId = Integer.parseInt(request.getParameter("projet_id"));

    ProjetDAO ProjetDAO = new ProjetDAO();
    Projet projet = null;
    try {
        projet = ProjetDAO.getProjetById(projetId);
    } catch (SQLException e) {
        e.printStackTrace();
        // Gérer l'erreur de récupération du projet
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors de la récupération du projet");
        return;
    }

    // Vérifier si le projet existe
    if (projet == null) {
        // Si le projet n'est pas trouvé, rediriger ou afficher un message d'erreur approprié
        response.sendRedirect("");
        return;
    }

    // Envoyer les détails du projet à la vue de modification
    request.setAttribute("projet", projet);
    request.getRequestDispatcher("modifierProjet.jsp").forward(request, response);
}

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String projectName = request.getParameter("project_name");
            String dateDebut = request.getParameter("date_debut");
            String dateFin = request.getParameter("date_fin");
            String membresEquipe = request.getParameter("membres_equipe");
            String etat = request.getParameter("etat");
            int projectManagerId = Integer.parseInt(request.getParameter("project_manager_id"));
        // récupérez les autres paramètres de la requête ici

            Projet projet = new Projet(projectName, dateDebut, dateFin, membresEquipe, etat, projectManagerId);

        try {
            projetDao.updateProjet(projet); // Appelez la méthode updateProjet de ProjetDao
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Projet mis à jour avec succès");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Une erreur s'est produite lors de la mise à jour du projet");
        }
    }


}
