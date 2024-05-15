package Controller;

import Model.Projet;
import DAO.ProjetDbUtil;
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
    private ProjetDbUtil projetDbUtil;
    Connection myConn;
    PreparedStatement myStmt ;
Projet projet;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our projet db util
        try {
            projetDbUtil = new ProjetDbUtil();
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
            //projetDbUtil.addProjet(newProjet);
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion", "root", "");

            // Créer la requête SQL
            String sql = "INSERT INTO projets (project_name, DateDebut, DateFin, MembresEquipe, etat) "
                         + "VALUES (?, ?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            // Définir les paramètres
            myStmt.setString(1, newProjet.getProject_name());
            myStmt.setDate(2, newProjet.getDateDebut());
            myStmt.setDate(3, newProjet.getDateFin());
            myStmt.setString(4, newProjet.getMembresEquipe());
            myStmt.setString(5, newProjet.getEtat());
            //myStmt.setInt(6, newProjet.getProject_manager_id());

            // Exécuter la requête
            myStmt.executeUpdate();
             
            // send back to the main page (redirect) request.getContextPath() + "/ProjetControllerServlet"
          response.sendRedirect(request.getContextPath() + "/listProjet.jsp");
            
        } catch (Exception ex) {
            Logger.getLogger(ProjetCreationServlet.class.getName()).log(Level.SEVERE, null, ex);
            // You may want to handle the exception differently, for example, by displaying an error message to the user.
            // For simplicity, we'll just forward to an error page for now.
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//            dispatcher.forward(request, response);
        }
    }
    
    
    
    
    /* static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        String project_name = request.getParameter("project_name");
        String date_debut = request.getParameter("date_debut");
        String date_fin = request.getParameter("date_fin");
        String membres_equipe = request.getParameter("membres_equipe");
        String etat = request.getParameter("etat");
        String project_manager_id = request.getParameter("project_manager_id");
        
       

        Projet projet = new Projet();
        projet.setProject_name(project_name);
        projet.setDateDebut(date_debut);
        projet.setDateFin(date_fin);
        projet.setMembresEquipe(membres_equipe);
        projet.setEtat(etat);
        projet.setProject_manager_id(project_manager_id);

        
      

        boolean success = projet.save();
        if (success) {
            request.setAttribute("message", "A new appointment has been successfully inserted!");
        } else {
            request.setAttribute("message", "Failed to insert the appointment.");
        }
        request.getRequestDispatcher("/AjoutProjet.jsp").forward(request, response);
    }*/
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

