package Controller;

import Model.*;

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
        if (this.user.username == username && this.user.password == password)
            return true;
        else
            return false;
    }

    public User getData() {
        return user;
    }
}
