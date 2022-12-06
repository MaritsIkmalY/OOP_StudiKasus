package View;

import Controller.ToDoController;
import Database.Db;
import Model.User;

public class MainView implements BaseView {
    public User user;
    public ToDoController todo;
    String title;
    String description;

    public MainView(Db db) {
        todo = new ToDoController(db);
    }

    public void set(User user) {
        this.user = user;
        todo.setOwner(user);
        menu();
    }

    public void menu() {
        int pilih;

        do {
            System.out.println("====================");
            System.out.println("Hai " + user.name() + ",\nMenu Aplikasi ToDo List");
            System.out.println("====================");
            System.out.println("1. Tampilkan Todo List");
            System.out.println("2. Tambah Todo List");
            System.out.println("3. Edit Todo List");
            System.out.println("4. Hapus Todo List");
            System.out.println("5. Data User");
            System.out.println("6. Logout");

            System.out.print("Pilih Menu : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> todo.show(user);

                case 2 -> {
                    this.inputData();
                    todo.store(user.id(), title, description);
                    todo.show(user);
                }

                case 3 -> {
                    todo.show(user);
                    System.out.print("Pilih ID Yang Ingin Di Edit : ");
                    try {
                        pilih = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error input!!");
                    }

                    this.inputData();

                    if (todo.edit(pilih, title, description)) {
                        System.out.println("ToDo Berhasil Di Edit!");
                        todo.show(user);
                    } else {
                        System.out.println("Tidak ada ToDo dengan Id " + pilih + "!\n");
                    }
                }

                case 4 -> {
                    todo.show(user);
                    System.out.print("Pilih Id Yang Ingin Di Hapus : ");
                    try {
                        pilih = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error input!!");
                    }

                    if (todo.destroy(pilih)) {
                        System.out.println("ToDo Berhasil Dihapus !");
                        todo.show(user);
                    } else {
                        System.out.println("Tidak ada ToDo dengan Id " + pilih);
                    }
                }

                case 5 -> this.showData();

                case 6 -> {
                    this.user = null;
                    System.out.println("Logout Berhasil!");
                }

                default -> System.out.println("Invalid Input");
            }

        } while (pilih != 6);
    }

    public void showData() {
        System.out.println("====================");
        System.out.println("Profile User");
        System.out.println("====================");
        System.out.println(user.toString());
    }

    public void inputData() {
        System.out.println("====================");
        System.out.println("Form ToDo List");
        System.out.println("====================");
        System.out.print("Judul Task : ");
        title = input.nextLine();
        System.out.print("Deskripsi Task : ");
        description = input.nextLine();
        System.out.println();
    }
}
