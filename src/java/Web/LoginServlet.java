// src/main/java/web/LoginServlet.java
package Web;

import Controller.LoginController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginController loginController;

    public void init() {
        loginController = new LoginController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("email");
        String password = request.getParameter("password");

        if (loginController.authenticate(username, password)) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("Vue/login.jsp");
        }
    }
}
