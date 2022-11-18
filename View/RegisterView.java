package View;

import Controller.DbController;
import Controller.RegisterController;
import Model.User;

import java.util.Scanner;

public class RegisterView implements LoginRegisterView {
    public RegisterController registerController;
    public DbController dbController;

    public RegisterView(DbController db) {
        registerController = new RegisterController();
        this.dbController = db;
        this.inputData();
    }

    public void inputData() {
        String name, username, password, phone, address;
        Scanner input = new Scanner(System.in);

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

        storeUser(registerController.generateUser(name, username, password, phone, address));
    }

    public void storeUser(User user) {
        dbController.dbUser.DataUser.add(user);
    }
}
