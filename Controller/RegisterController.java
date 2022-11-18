package Controller;

import Model.DbUser;
import Model.User;

public class RegisterController {
    public User generateUser(String name, String username, String password, String phone, String address) {
        return new User(name, username, password, phone, address);
    }

    public void storeUser(DbUser db, User user) {
        db.DataUser.add(user);
    }

}