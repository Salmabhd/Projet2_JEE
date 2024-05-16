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

public class ProjetDAO {
   Projet projet;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestionprojets";
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
        public void addProjet(Projet projet) throws SQLException, ClassNotFoundException {
        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // Établir la connexion
            Class.forName("com.mysql.cj.jdbc.Driver");
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
     
    public void updateProjet(Projet projet) throws SQLException, ClassNotFoundException {
    Connection myConn = null;
    PreparedStatement myStmt = null;

    try {
        // Établir la connexion
        Class.forName("com.mysql.cj.jdbc.Driver");
        myConn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

        // Créer la requête SQL
        String sql = "UPDATE projets SET project_name=?, DateDebut=?, DateFin=?, MembresEquipe=?, etat=?, project_manager_id=? WHERE projet_id=?";

        myStmt = myConn.prepareStatement(sql);

        // Définir les paramètres
        myStmt.setString(1, projet.getProject_name());
        myStmt.setDate(2, projet.getDateDebut());
        myStmt.setDate(3, projet.getDateFin());
        myStmt.setString(4, projet.getMembresEquipe());
        myStmt.setString(5, projet.getEtat());
        myStmt.setInt(6, projet.getProject_manager_id());
        myStmt.setInt(7, projet.getProjet_id());

        // Exécuter la requête
        myStmt.executeUpdate();
    } finally {
        // Fermer les ressources JDBC
        close(myConn, myStmt, null);
    }
}
    
    public void supprimerProjet(int projetId) throws SQLException {
    Connection myConn = null;
    PreparedStatement myStmt = null;

    try {
        // Établir la connexion
        Class.forName("com.mysql.cj.jdbc.Driver");
        myConn = DriverManager.getConnection("jdbc:mysql://localhost/gestionprojets", "root", "");

        // Créer la requête SQL
        String sql = "DELETE FROM projets WHERE projet_id=?";

        myStmt = myConn.prepareStatement(sql);

        // Définir le paramètre
        myStmt.setInt(1, projetId);

        // Exécuter la requête
        myStmt.executeUpdate();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    } finally {
        // Fermer les ressources JDBC
        close(myConn, myStmt, null);
    }
}

      
      
      

    public Projet getProjetById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Projet projet = null;

        try {
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM projets WHERE projet_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                projet = extractProjetFromResultSet(rs);
            }
        } finally {
            close(conn, stmt, rs);
        }

        return projet;
    }

    private Projet extractProjetFromResultSet(ResultSet rs) throws SQLException {
        int projet_id = rs.getInt("projet_id");
        String project_name = rs.getString("project_name");
        Date dateDebut = rs.getDate("DateDebut");
        Date dateFin = rs.getDate("DateFin");
        String MembresEquipe = rs.getString("MembresEquipe");
        String etat = rs.getString("etat");
        int project_manager_id = rs.getInt("project_manager_id");

        return new Projet(projet_id, project_name, dateDebut, dateFin, MembresEquipe, etat, project_manager_id);
    }
 
    
     public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:9090/gestionprojets", "root", "");
    }

    public boolean save(Projet projet) {
     String sql = "INSERT INTO projets (project_name, DateDebut, DateFin, MembresEquipe, etat, project_manager_id) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";
     try (Connection conn = getConnection();
             PreparedStatement myStmt = conn.prepareStatement(sql)) {
            myStmt.setString(1, projet.getProject_name());
            myStmt.setDate(2, projet.getDateDebut());
            myStmt.setDate(3, projet.getDateFin());
            myStmt.setString(4, projet.getMembresEquipe());
            myStmt.setString(5, projet.getEtat());
            myStmt.setInt(6, projet.getProject_manager_id());

            int rowsInserted = myStmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
}
