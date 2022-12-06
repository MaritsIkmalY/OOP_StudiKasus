package View;

import Controller.RegisterController;
import Database.Db;
import Model.User;

public class RegisterView implements BaseView {
    public RegisterController registerController;
    public Db db;

    public RegisterView(Db db) {
        registerController = new RegisterController();
        this.db = db;
    }

    public void inputData() {
        User user;
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

        user = registerController.generateUser(name, username, password, phone, address);
        if (registerController.storeUser(db, user)) {
            System.out.println("Registrasi berhasil !");
        } else {
            System.out.println("Registrasi Gagal, ada data yang kembar");
        }
    }
}
