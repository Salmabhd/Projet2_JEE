// Source Packages/model/User.java
package Model;

public class User {
    private String email;
    private String password;

    public User(String username, String password) {
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}