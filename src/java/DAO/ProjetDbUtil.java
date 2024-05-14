package DAO;

import Model.Projet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ProjetDbUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:9090/gestionprojets";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public List<Projet> getProjets() throws SQLException {

        List<Projet> projets = new ArrayList<>();
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet Rs ;

        try {
            // Établir la connexion
            myConn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             
            // Créer la requête SQL
            String sql = "SELECT * FROM projets";
            myStmt = myConn.createStatement();

            // Exécuter la requête
            Rs = myStmt.executeQuery(sql);

            // Traiter le résultat
            while (Rs.next()) {
                int projet_id = Rs.getInt("projet_id");
                String project_name = Rs.getString("project_name");
                Date DateDebut = Rs.getDate("DateDebut");
                Date DateFin = Rs.getDate("DateFin");
                String MembresEquipe = Rs.getString("MembresEquipe");
                String etat = Rs.getString("etat");
                int project_manager_id = Rs.getInt("project_manager_id");

                Projet tempProjet = new Projet(projet_id, project_name, DateDebut, DateFin, MembresEquipe, etat, project_manager_id);

                projets.add(tempProjet);
            }

            return projets;
        } finally {
            // Fermer les ressources JDBC
            myConn.close();
            //close(myConn, myStmt, Rs);
        }
    }
        public void addProjet(Projet projet) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // Établir la connexion
            myConn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Créer la requête SQL
            String sql = "INSERT INTO projets (project_name, DateDebut, DateFin, MembresEquipe, etat, project_manager_id) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";
            myStmt = myConn.prepareStatement(sql);

            // Définir les paramètres
            myStmt.setString(1, projet.getProject_name());
            myStmt.setDate(2, projet.getDateDebut());
            myStmt.setDate(3, projet.getDateFin());
            myStmt.setString(4, projet.getMembresEquipe());
            myStmt.setString(5, projet.getEtat());
            myStmt.setInt(6, projet.getProject_manager_id());

            // Exécuter la requête
            myStmt.executeUpdate();
        } finally {
            // Fermer les ressources JDBC
            close(myConn, myStmt, null);
        }
    }


    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
}
