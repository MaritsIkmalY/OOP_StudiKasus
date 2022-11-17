package View;

import Model.*;
import Controller.*;

public class MainView {
    public UserController userController;
    public User user;

    public getController(UserController userController) {
        this.userController = userController;
    }

    public void showData() {
        user = userController.getData();
        System.out.println("Nama : " + user.name);
        System.out.println("Phone : " + user.phone);
        System.out.println("Address : " + user.address);
    }

}
