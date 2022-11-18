package View;

import Model.User;

public class MainView {

    public MainView(User user) {
        showData(user);
    }

    public void showData(User user) {
        System.out.println("====================");
        System.out.println("Main View");
        System.out.println("====================");
        System.out.println("Nama : " + user.name);
        System.out.println("Phone : " + user.phone);
        System.out.println("Address : " + user.address);
    }

}
