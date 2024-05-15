package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private String jdbcURL = "jdbc:MySQL://localhost:3306/gestion";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM compte WHERE email = ?";

    public UserDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("Connexion à la base de données établie avec succès.");
        } catch (ClassNotFoundException e) {
             System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());;
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public User getUserByUsername(String username) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                user = new User(email, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}