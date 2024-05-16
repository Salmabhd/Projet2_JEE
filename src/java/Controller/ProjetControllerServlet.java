package Controller;

import Model.Projet;
import DAO.ProjetDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/ProjetControllerServlet")
public class ProjetControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProjetDAO projetDbUtil;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our projet db util
        try {
            projetDbUtil = new ProjetDAO();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // list the projets
            listProjets(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ProjetControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void listProjets(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get projets from db util
        List<Projet> projets = projetDbUtil.getProjets();

        // add projets to the request
         request.setAttribute("PROJET_LIST", projets);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("listProjets.jsp");
        dispatcher.forward(request, response);
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    try {
        switch (action) {
            case "supprimer":
                supprimerProjet(request, response);
                break;
            default:
                listProjets(request, response);
                break;
        }
    } catch (Exception ex) {
        Logger.getLogger(ProjetControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void supprimerProjet(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // Récupérer l'identifiant du projet à supprimer
    int projetId = Integer.parseInt(request.getParameter("projet_id"));

    // Appeler la méthode de suppression dans le DAO
    projetDbUtil.supprimerProjet(projetId);

    // Rediriger vers la page de liste des projets après la suppression
    response.sendRedirect(request.getContextPath() + "/ProjetControllerServlet");
}

}
