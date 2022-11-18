package View;

import Controller.DbController;
import Controller.RegisterController;
import Model.User;

public class RegisterView extends AuthView {
    public RegisterController registerController;

    public RegisterView(DbController db) {
        registerController = new RegisterController();
        this.dbController = db;
        this.inputData();
    }

    public void inputData() {
        String name;
        String username;
        String password;
        String phone;
        String address;
        User user;

        System.out.println("====================");
        System.out.println("Register Form");
        System.out.println("====================");

        System.out.print("Masukkan Name : ");
        name = input.nextLine();
        System.out.print("Masukkan Username : ");
        username = input.nextLine();
        System.out.print("Masukkan Password : ");
        password = input.nextLine();
        System.out.print("Masukkan Phone : ");
        phone = input.nextLine();
        System.out.print("Masukkan Address : ");
        address = input.nextLine();

        user = registerController.generateUser(name, username, password, phone, address);
        registerController.storeUser(dbController.dbUser,user);
    }
}
