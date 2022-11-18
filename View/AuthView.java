package View;

import Controller.DbController;

import java.util.Scanner;

public abstract class AuthView {
    public DbController dbController;
    public Scanner input = new Scanner(System.in);

    public abstract void inputData();
}
