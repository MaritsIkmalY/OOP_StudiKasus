package Controller;

import Database.Db;
import Model.User;

public class RegisterController {
    public User generateUser(String name, String username, String password, String phone, String address) {
        return new User(name, username, password, phone, address );
    }

    public void storeUser(Db db, User user) {
        db.User.add(user);
    }

}