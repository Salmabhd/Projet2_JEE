package Projets;

import Projets.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;


import javax.sql.DataSource;

public class ProjetDbUtil {

	private DataSource dataSource;

	public ProjetDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Projet> getProjets() throws Exception {
		
		List<Projet> projets = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from projets ";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int projet_id = myRs.getInt("projet_id");
				String project_name = myRs.getString("project_name");
				Date DateDebut = myRs.getDate("DateDebut");
				Date DateFin = myRs.getDate("DateFin");
                                String MembresEquipe = myRs.getString("MembresEquipe");
                                String etat = myRs.getString("etat");
				int project_manager_id = myRs.getInt("project_manager_id");


				
				// create new student object
				Projet tempProjet = new Projet(projet_id, project_name, DateDebut,DateFin,MembresEquipe,etat,project_manager_id);
				
				// add it to the list of students
				projets.add(tempProjet);				
			}
			
			return projets;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
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
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}















