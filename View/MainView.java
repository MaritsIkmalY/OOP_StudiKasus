package View;

import Controller.DbConnection;
import Controller.ToDoController;
import Database.Db;
import Model.User;

public class MainView implements BaseView {
    public User user;
    public ToDoController todo;
    String title;
    String description;

    public MainView(User user, Db db) {
        todo = new ToDoController(db);
        this.user = user;
        menu();
    }

    public void menu() {
        int pilih;
        char jawab;

        do {
            System.out.println("====================");
            System.out.println("Aplikasi ToDo List");
            System.out.println("====================");
            System.out.println("1. Tampilkan Todo List");
            System.out.println("2. Tambah Todo List");
            System.out.println("3. Edit Todo List");
            System.out.println("4. Hapus Todo List");
            System.out.println("5. Data User");

            System.out.print("Pilih Menu : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1 -> todo.show(user);

                case 2 -> {
                    this.inputData();
                    todo.store(user.id, title, description);
                }

                case 3 -> {
                    todo.show(user);
                    System.out.print("Pilih ID Yang Ingin Di Edit : ");
                    pilih = input.nextInt();
                    input.nextLine();
                    if (todo.edit(pilih, title, description)) {
                        this.formEdit();
                        System.out.println("ToDo Berhasil Di Edit!");
                    } else {
                        System.out.println("Tidak ada ToDO dengan Id " + pilih);
                    }
                }

                case 4 -> {
                    todo.show(user);
                    System.out.print("Pilih ID Yang Ingin Di Hapus : ");
                    pilih = input.nextInt();
                    input.nextLine();
                    if (todo.destroy(pilih)) {
                        System.out.print("ToDo Berhasil Dihapus !");
                    } else {
                        System.out.println("Inputan id salah !");
                    }
                }

                case 5 -> this.showData();

                default -> System.out.println("Invalid Input");
            }
            System.out.print("Mau Lagi ? y / t : ");
            jawab = input.next().charAt(0);
        } while (jawab == 'y' || jawab == 'Y');
    }

    public void showData() {
        System.out.println("====================");
        System.out.println("Profile User");
        System.out.println("====================");
        System.out.println("Nama : " + user.name);
        System.out.println("Id : " + user.id);
        System.out.println("Username : " + user.username);
        System.out.println("Address : " + user.address);
        System.out.println("Phone : " + user.phone);
    }

    public void inputData() {
        System.out.println("====================");
        System.out.println("Form Tambah ToDo List");
        System.out.println("====================");
        System.out.print("Judul Task : ");
        title = input.nextLine();
        System.out.print("Deskripsi Task : ");
        description = input.nextLine();
        System.out.println();
    }

    public void formEdit() {
        System.out.println("====================");
        System.out.println("Form Edit ToDo List");
        System.out.println("====================");
        System.out.print("Judul Task : ");
        title = input.nextLine();
        System.out.print("Deskripsi Task : ");
        description = input.nextLine();
        System.out.println();
    }
}
