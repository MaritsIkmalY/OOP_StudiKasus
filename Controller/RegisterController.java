package Controller;

import Model.User;

import java.util.ArrayList;
import java.util.Objects;

public class RegisterController {
    int incrementId = 1;

    public User generateUser(String name, String username, String password, String phone, String address) {
        incrementId++;
        return new User(incrementId, name, username, password, phone, address);
    }//user baru

    public boolean storeUser(ArrayList<User> users, User user) {
        //ngecek usernmae sudah ada /blm di array list?
        for(User userdb : users) {
            if(Objects.equals(userdb.username(),user.username())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

}