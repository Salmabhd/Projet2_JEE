package Model;

import com.mysql.jdbc.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Projet {
	private int projet_id;
	private String project_name;
	private Date DateDebut;
        private Date DateFin;
	private String MembresEquipe;
        private String etat;
        private int project_manager_id;

       public Projet(){}
   
	public Projet(int projet_id, String project_name, Date DateDebut, Date DateFin, String MembresEquipe, String etat, int project_manager_id) {
        this.projet_id = projet_id;
        this.project_name = project_name;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        this.MembresEquipe = MembresEquipe;
        this.etat = etat;
        this.project_manager_id = project_manager_id;
    }

    public Projet(String projectName, String dateDebut, String dateFin, String membresEquipe, String etat, int projectManagerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters
    public int getProjet_id() {
        return projet_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public String getMembresEquipe() {
        return MembresEquipe;
    }

    public String getEtat() {
        return etat;
    }

    public int getProject_manager_id() {
        return project_manager_id;
    }

    // Setters
    public void setProjet_id(int projet_id) {
        this.projet_id = projet_id;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public void setMembresEquipe(String MembresEquipe) {
        this.MembresEquipe = MembresEquipe;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setProject_manager_id(int project_manager_id) {
        this.project_manager_id = project_manager_id;
    }

    
    
    
 @Override
    public String toString() {
        return "Projet{" +
                "projet_id=" + projet_id +
                ", project_name='" + project_name + '\'' +
                ", DateDebut=" + DateDebut +
                ", DateFin=" + DateFin +
                ", MembresEquipe='" + MembresEquipe + '\'' +
                ", etat='" + etat + '\'' +
                ", project_manager_id=" + project_manager_id +
                '}';
    }	
     public static java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:9090/gestionprojets", "root", "");
    }

    public boolean save() {
     String sql = "INSERT INTO projets (project_name, DateDebut, DateFin, MembresEquipe, etat, project_manager_id) "
                         + "VALUES (?, ?, ?, ?, ?, ?)";
     try (java.sql.Connection conn = getConnection();
             PreparedStatement myStmt = conn.prepareStatement(sql)) {
            myStmt.setString(1, this.getProject_name());
            myStmt.setDate(2, this.getDateDebut());
            myStmt.setDate(3, this.getDateFin());
            myStmt.setString(4, this.getMembresEquipe());
            myStmt.setString(5, this.getEtat());
            myStmt.setInt(6, this.getProject_manager_id());

            int rowsInserted = myStmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
      
    }

    public void setDateDebut(String date_debut) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDateFin(String date_fin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setProject_manager_id(String project_manager_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
