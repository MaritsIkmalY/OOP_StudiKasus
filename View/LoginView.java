package View;

import Controller.DbController;
import Controller.LoginController;

public class LoginView extends AuthView {
    public LoginController loginController;

    public LoginView() {
        dbController = new DbController();
        loginController = new LoginController();
    }

    public void alreadyRegistered() {
        char jawaban;

        do {
            System.out.println("====================");
            System.out.println("System Login Register sederhana");
            System.out.println("====================");
            System.out.print("Apakah Kamu Sudah Memiliki Akun ? (y/t) :");
            jawaban = input.next().charAt(0);
            input.nextLine();

            switch (jawaban) {
                case 'y' -> this.inputData();
                case 't' -> {
                    new RegisterView(dbController);
                    this.inputData();
                }
                default -> System.out.println("Invalid Input");
            }

            System.out.print("\nIngin login kembali ? (y / t) : ");
            jawaban = input.next().charAt(0);
            input.nextLine();
        } while (jawaban == 'y');

    }

    public void inputData() {
        boolean authCheck;
        String username;
        String password;

        System.out.println("====================");
        System.out.println("Login Form");
        System.out.println("====================");

        System.out.print("Masukkan Username : ");
        username = input.nextLine();
        System.out.print("Masukkan Password : ");
        password = input.nextLine();

        authCheck = this.loginController.Authentication(dbController.dbUser, username, password);
        if (authCheck) {
            new MainView(loginController.user);
        } else
            System.out.println("Data not match in out record !!");
    }
}
