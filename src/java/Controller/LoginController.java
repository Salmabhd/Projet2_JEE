package Controller;

import DAO.UserDao;
import Model.User;

public class LoginController {
    private UserDao userDao;

    public LoginController() {
        userDao = new UserDao();
    }

    public boolean authenticate(String email, String password) {
        User user = userDao.getUserByUsername(email);
        return user != null && password.equals(user.getPassword());
    }
}