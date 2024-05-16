package Controller;

import Model.Projet;
import DAO.ProjetDAO;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjoutProjet")
public class ProjetCreationServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    private ProjetDAO projetDAO;
    Connection myConn;
    PreparedStatement myStmt ;
Projet projet;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our projet db util
        try {
            projetDAO = new ProjetDAO();
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // process the form data
            String projectName = request.getParameter("project_name");
            String dateDebut = request.getParameter("date_debut");
            String dateFin = request.getParameter("date_fin");
            String membresEquipe = request.getParameter("membres_equipe");
            String etat = request.getParameter("etat");
            int projectManagerId = Integer.parseInt(request.getParameter("project_manager_id"));

            // create a new Projet object
            Projet newProjet = new Projet(projectName, dateDebut, dateFin, membresEquipe, etat, projectManagerId);

            // add the Projet to the database
            projetDAO.addProjet(newProjet);
        
            // send back to the main page (redirect) request.getContextPath() + "/ProjetControllerServlet"
          response.sendRedirect(request.getContextPath() + "/listProjet.jsp");
            
        } catch (Exception ex) {
            Logger.getLogger(ProjetCreationServlet.class.getName()).log(Level.SEVERE, null, ex);
            // You may want to handle the exception differently, for example, by displaying an error message to the user.
            // For simplicity, we'll just forward to an error page for now.
          RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
           dispatcher.forward(request, response);
        }
    }
    
}
    
    

    
    
    
    
    
    
    
    
  
    

