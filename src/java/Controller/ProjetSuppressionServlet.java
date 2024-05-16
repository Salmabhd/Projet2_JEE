package Controller;

import Model.Projet;
import DAO.ProjetDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProjetSuppressionServlet", urlPatterns = {"/supprimerProjet"})
public class ProjetSuppressionServlet extends HttpServlet  {
    private ProjetDAO projetDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID du projet depuis les paramètres de requête
        int projetId = Integer.parseInt(request.getParameter("projet_id"));

        try {
            projetDao.deleteProjet(projetId); // Appel de la méthode deleteProjet de ProjetDAO
            response.sendRedirect("index.jsp"); // Redirection vers la page d'accueil après la suppression
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur de suppression du projet
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors de la suppression du projet");
        }
    }
}