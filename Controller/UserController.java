package Controller;

import Model.*;

import java.util.Objects;

public class UserController {
    public User user;

    public void generateUser(String name, String username, String password, String phone, String address) {
        this.user = new User();

        this.user.name = name;
        this.user.username = username;
        this.user.password = password;
        this.user.phone = phone;
        this.user.address = address;
    }

    public boolean checkUser(String username, String password) {
        return Objects.equals(this.user.username, username) && Objects.equals(this.user.password, password);
    }

    public User getData() {
        return user;
    }
}
