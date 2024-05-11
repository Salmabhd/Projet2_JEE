package Projets;

import Projets.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class ProjetControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProjetDbUtil projetDbUtil;
	
	@Resource(name="jdbc/gestionprojets")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			projetDbUtil = new ProjetDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            try {
                // list the students ... in mvc fashion
                listProjets(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ProjetControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}

	private void listProjets(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get students from db util
		List<Projet> projets = projetDbUtil.getProjets();
		
		// add students to the request
		request.setAttribute("STUDENT_LIST", projets);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

}













