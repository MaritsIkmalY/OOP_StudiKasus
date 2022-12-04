package Controller;

import Database.Db;
import Model.User;

public class RegisterController {
    int id = 0;

    public User generateUser(String name, String username, String password, String phone, String address) {
        id++;
        return new User(id, name, username, password, phone, address);
    }

    public void storeUser(Db db, User user) {
        db.User.add(user);
    }

}