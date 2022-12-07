package Controller;

import Model.User;

import java.util.ArrayList;
import java.util.Objects;

public class LoginController {
    private User authUser;

    public boolean Authentication(ArrayList<User> users, String username, String password) {
        for (User user : users) {
            if (Objects.equals(user.username(), username) && Objects.equals(user.password(), password)) {
                setAuthUser(user);
                return true;
            }
        }
        return false;
    }//pengecekan

    public void setAuthUser(User user) {
        this.authUser = user;
    } // set auth user

    public User getAuthUser() {
        return authUser;
    }
}