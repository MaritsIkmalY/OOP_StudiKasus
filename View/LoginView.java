package View;

import Controller.DbConnection;
import Controller.LoginController;

public class LoginView implements BaseView {
    public DbConnection dbConnection;
    public LoginController loginController;
    public RegisterView registerView;
    public TodoView todOView;

    public LoginView() {
        dbConnection = new DbConnection();
        loginController = new LoginController();
        registerView = new RegisterView(dbConnection.db.User);
        todOView = new TodoView(dbConnection.db.Todo);
    }

    public void start() {
        int pilih = 0;

        do {
            System.out.println("====================");
            System.out.println("Welcome to Todo List App");
            System.out.println("====================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            System.out.print("Pilih Menu : ");
            try {
                pilih = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("input only for number");
                input.nextLine();
            }
            switch (pilih) {
                case 1 -> this.inputData();
                case 2 -> {
                    registerView.inputData();
                    this.inputData();
                }
                case 3 -> System.out.print("Program end...");
                default -> System.out.println("Invalid Input select beetwen 1 - 3");
            }
            System.out.println();
        } while (pilih != 3);
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

        status = this.loginController.Authentication(dbConnection.db.User, username, password);
        if (status) {
            System.out.println("Berhasil login !");
            todOView.set(loginController.getAuthUser());
            loginController.setAuthUser(null);
        } else
            System.out.println("Data not match in our record !!");
    }
}
