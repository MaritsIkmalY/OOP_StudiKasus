package View;

import java.util.Scanner;
import Controller.*;

public class RegisterView implements LoginRegisterView {
    public UserController userController;

    public void inputData() {
        String name, username, password, phone, address;
        Scanner input = new Scanner(System.in);

        public getController(UserController userController) {
            this.userController = userController;
        }
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

        this.userController.generateUser(name, username, password, phone, address);

        input.close();
    }
}
