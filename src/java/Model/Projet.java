package Model;

import java.sql.Date;

public class Projet {
	private int projet_id;
	private String project_name;
	private Date DateDebut;
        private Date DateFin;
	private String MembresEquipe;
        private String etat;
        private int project_manager_id;


   
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
}
