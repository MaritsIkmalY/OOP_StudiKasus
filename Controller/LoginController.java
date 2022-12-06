package Controller;

import Database.Db;
import Model.User;

import java.util.Objects;

public class LoginController {
    public User user;

    public boolean Authentication(Db db, String username, String password) {
        for (User user : db.User) {

            if (Objects.equals(user.username(), username) && Objects.equals(user.password(), password)) {
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