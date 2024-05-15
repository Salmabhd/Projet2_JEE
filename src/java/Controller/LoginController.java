package Controller;

import DAO.UserDao;
import Model.User;
import org.mindrot.jbcrypt.BCrypt;

public class LoginController {
    private UserDao userDao;

    public LoginController() {
        userDao = new UserDao();
    }

    public boolean authenticate(String username, String password) {
        User user = userDao.getUserByUsername(username);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }
}
