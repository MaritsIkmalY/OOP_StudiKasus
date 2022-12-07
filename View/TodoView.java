package View;

import Controller.ToDoController;
import Model.ToDo;
import Model.User;
import View.Components.Table;

import java.util.ArrayList;

public class TodoView implements BaseView {
    public User user;
    public ToDoController todo;
    String title;
    String description;

    public TodoView(ArrayList<ToDo> todo) {
        this.todo = new ToDoController(todo);
    }

    public void set(User user) {
        this.user = user;
        menu();
    }

    public void menu() {
        int pilih = 0;
        int id = 0;

        do {
            System.out.println("====================");
            System.out.println("Selamat Datang " + user.name() + ",\nMenu Aplikasi ToDo List");
            System.out.println("====================");
            System.out.println("1. Tampilkan Todo List");
            System.out.println("2. Tambah Todo List");
            System.out.println("3. Edit Todo List");
            System.out.println("4. Hapus Todo List");
            System.out.println("5. Data User");
            System.out.println("6. Logout");

            System.out.print("Pilih Menu : ");
            try {
                pilih = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Input only number 1 - 6");
                input.nextLine();
            }

            switch (pilih) {
                case 1 -> this.showTodo();

                case 2 -> {
                    this.inputData();
                    todo.store(user.id(), user.username(), title, description);
                    this.showTodo();
                }

                case 3 -> {
                    this.showTodo();
                    System.out.print("Pilih Id Yang Ingin Di Edit : ");
                    try {
                        id = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error input!!");
                        input.nextLine();
                    }
                    this.inputData();
                    todo.edit(id, user.id(), title, description);
                }

                case 4 -> {
                    this.showTodo();
                    System.out.print("Pilih Id Yang Ingin Di Hapus : ");
                    try {
                        id = input.nextInt();
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Error input!!");
                        input.nextLine();
                    }
                    todo.destroy(id, user.id());
                }

                case 5 -> this.showData();

                case 6 -> {
                    this.user = null;
                    System.out.println("Logout Berhasil!");
                }
                default -> System.out.println("Invalid Input, select beetwen 1 - 6");
            }
        } while (pilih != 6);
    }

    public void showData() {
        System.out.println("====================");
        System.out.println("Profile User");
        System.out.println("====================");
        System.out.println(user.toString());
    }

    public void showTodo() {
        Table table = new Table();
        ArrayList<ToDo> todos = todo.getAllTodos();
        table.setShowVerticalLines(true);
        table.setHeaders("Id", "Author", "Judul", "Description", "Created at", "Last Modified");
        for (ToDo todo : todos) {
            table.addRow(String.valueOf(todo.getId()), todo.getOwner(), todo.getTitle(), todo.getDescription(), todo.getCreated_at(), todo.getLast_updated());
        }
        table.print();
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
