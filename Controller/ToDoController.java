package Controller;

import Database.Db;
import Model.ToDo;
import Model.User;

public class ToDoController {
    public User user;
    public Db db;
    int incrementID = 1;

    public ToDoController(Db db) {
        this.db = db;
    }

    public void setOwner(User user) {
        this.user = user;
    }

    public void show(User user) {
        System.out.println("====================");
        System.out.println("Show ToDo List");
        System.out.println("====================");
        System.out.println("id\tJudul\tDescription");
        System.out.println("====================");
        if (db.Todo.size() < 1) {
            System.out.println("<<Belum Ada Todo List...>>");
        }
        for (ToDo ToDo : db.Todo) {
            if (ToDo.getUser_id() == user.id()) {
                System.out.print(" " + ToDo.getId() + "\t");
                System.out.print(ToDo.getTitle() + "\t");
                System.out.print(ToDo.getDescription());
                System.out.println();
            }
        }
        System.out.println();
    }

    public void store(int owner, String title, String description) {
        try {
            if (db.Todo.add(new ToDo(incrementID, owner, title, description))) {
                incrementID++;
                System.out.println("Todo Berhasil Ditambahkan !");
            }
        } catch (Exception e) {
            System.out.println("Something Error !!");
        }
    }

    public boolean edit(int id, String title, String description) {
        for (ToDo ToDo : db.Todo) {
            if (ToDo.getId() == id && ToDo.getUser_id() == user.id()) {
                if (title != null && !title.trim().isEmpty()) {
                    ToDo.setTitle(title);
                }

                if (description != null && !description.trim().isEmpty()) {
                    ToDo.setDescription(description);
                }

                return true;
            }
        }
        return false;
    }

    public boolean destroy(int id) {
        for (ToDo ToDo : db.Todo) {
            if (ToDo.getId() == id && ToDo.getUser_id() == user.id()) {
                db.Todo.remove(id - 1);
                return true;
            }
        }
        return false;
    }
}