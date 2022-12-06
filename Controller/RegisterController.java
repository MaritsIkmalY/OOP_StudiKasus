package Controller;

import Database.Db;
import Model.User;

import java.util.Objects;

public class RegisterController {
    int incrementId = 1;

    public User generateUser(String name, String username, String password, String phone, String address) {
        incrementId++;
        return new User(incrementId, name, username, password, phone, address);
    }//user baru

    public boolean storeUser(Db db, User user) {
        //ngecek usernmae sudah ada /blm di array list?
        for(User userdb : db.User) {
            if(Objects.equals(userdb.username(),user.username())) {
                return false;
            }
        }
        db.User.add(user);
        return true;
    }

}