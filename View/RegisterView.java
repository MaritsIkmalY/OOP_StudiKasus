package View;

import Controller.RegisterController;
import Model.User;
import java.util.ArrayList;

public class RegisterView implements BaseView {
    public RegisterController registerController;
    public ArrayList<User> users;

    public RegisterView(ArrayList<User> users) {
        registerController = new RegisterController();
        this.users = users;
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
        if (registerController.storeUser(users, user)) {
            System.out.println("Registrasi berhasil !");
        } else {
            System.out.println("Registrasi Gagal, ada data yang kembar");
        }
    }
}
