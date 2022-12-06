package View;

import Controller.DbConnection;
import Controller.LoginController;

public class LoginView implements BaseView {
    public DbConnection dbConnection;
    public LoginController loginController;
    public RegisterView registerView;
    public MainView mainView;

    public LoginView() {
        dbConnection = new DbConnection();
        loginController = new LoginController();
        registerView = new RegisterView(dbConnection.db);
        mainView = new MainView(dbConnection.db);
    }

    public void start() {
        char jawaban;

        do {
            System.out.println("====================");
            System.out.println("Welcome to Todo List App");
            System.out.println("====================");
            System.out.print("Apakah Kamu Sudah Memiliki Akun ? (y/t) : ");
            jawaban = input.next().charAt(0);
            input.nextLine();

            switch (jawaban) {
                case 'y' -> this.inputData();
                case 't' -> {
                    registerView.inputData();
                    this.inputData();
                }
                default -> System.out.println("Invalid Input");
            }

            System.out.print("\nIngin login kembali ? (y / t) : ");
            jawaban = input.next().charAt(0);
            input.nextLine();
            System.out.println();
        } while (jawaban == 'y');

    }

    public void inputData() {
        boolean status;
        String username;
        String password;

        System.out.println("====================");
        System.out.println("Login Form");
        System.out.println("====================");

        System.out.print("Masukkan Username : ");
        username = input.nextLine();
        System.out.print("Masukkan Password : ");
        password = input.nextLine();

        status = this.loginController.Authentication(dbConnection.db, username, password);
        if (status) {
           mainView.set(loginController.user);
           loginController.user = null;
        } else
            System.out.println("Data not match in out record !!");
    }
}
