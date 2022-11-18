package Controller;

import Model.User;

import java.util.Objects;

public class LoginController {
    public User user;

    public boolean Authentication(DbController db, String username, String password) {
        for (User user : db.dbUser.DataUser) {

            if (Objects.equals(user.username, username) && Objects.equals(user.password, password)) {
                setAuthUser(user);
                return true;
            }
        }
        return false;
    }

    public void setAuthUser(User user) {
        this.user = user;
    }
}