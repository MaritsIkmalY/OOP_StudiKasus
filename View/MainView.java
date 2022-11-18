package View;

import Model.*;

public class MainView {
    public User user;

    public MainView(User user) {
        this.user = user;
        showData();
    }


    public void showData() {
        System.out.println("====================");
        System.out.println("Main View");
        System.out.println("====================");
        System.out.println("Nama : " + user.name);
        System.out.println("Phone : " + user.phone);
        System.out.println("Address : " + user.address);
    }

}
