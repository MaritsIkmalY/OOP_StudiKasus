package View;

import java.util.Scanner;
import Controller.*;

public class LoginView implements LoginRegisterView {
    public UserController userController = new UserController();
    Scanner input = new Scanner(System.in);

    public void alreadyRegistered() {
        int jawaban;

        System.out.print("Apakah Kamu Sudah Memiliki Akun ? (1/0) :");
        jawaban = input.nextInt();
        switch (jawaban) {
            case 1:
                this.inputData();
                break;
            case 0:
                RegisterView registerView = new RegisterView();
                registerView.inputData();
                break;
            default:
                System.out.println("Invalid");
        }
        input.close();
    }

    public void inputData() {
        boolean status;
        String username;
        String password;

        System.out.print("Masukkan Username : ");
        username = input.nextLine();
        System.out.print("Masukkan Password : ");
        password = input.nextLine();

        status = this.userController.checkUser(username, password);
        if (status) {
            MainView mainView = new MainView();
            mainView.showData();
        } else
            System.out.println("Gagal Masuk");
        input.close();
    }
}
