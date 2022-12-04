package View;

import Controller.RegisterController;
import Database.Db;

public class RegisterView implements BaseView {
    public RegisterController registerController;
    public Db db;

    public RegisterView(Db db) {
        registerController = new RegisterController();
        this.db = db;
        this.inputData();
    }

    public void inputData() {
        String name, username, password, phone, address;
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

        registerController.storeUser(db, registerController.generateUser(name, username, password, phone, address));
    }
}
