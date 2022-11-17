package View;

import Controller.UserController;

import java.util.Scanner;

public class LoginView implements LoginRegisterView {
    public UserController userController = new UserController();
    Scanner input = new Scanner(System.in);

    public void alreadyRegistered() {
        int jawaban;

        System.out.print("Apakah Kamu Sudah Memiliki Akun ? (1/0) :");
        jawaban = input.nextInt();
        input.nextLine();
        switch (jawaban) {
            case 1 -> this.inputData();
            case 0 -> {
                RegisterView registerView = new RegisterView(userController);
                registerView.inputData();
                this.inputData();
            }
            default -> System.out.println("Invalid");
        }
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
            MainView mainView = new MainView(userController);
            mainView.showData();
        } else
            System.out.println("Gagal Masuk");


    }
}
