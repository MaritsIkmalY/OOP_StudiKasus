package Controller;

import Database.Db;
import Model.ToDo;
import Model.User;

public class ToDoController {
    public Db db;
    public User user;
    int incrementID = 1;

    public ToDoController(Db db) {
        this.db = db;
    }

    public void setOwner(User user) {
        this.user = user;
    }

    public void show() {
        System.out.println("====================");
        System.out.println("Show ToDo List");
        System.out.println("====================");
        System.out.println("id\tJudul\tDescription");
        for(ToDo ToDo : db.Todo) {
            if(ToDo.owner_id == user.id) {
                System.out.print(" " + ToDo.id + "\t");
                System.out.print(ToDo.title + "\t");
                System.out.print(ToDo.description);
                System.out.println();
            }
        }
    }

    public void store(String title, String description) {
        try {
           if( db.Todo.add(new ToDo(incrementID, user.id, title, description)) ) {
               incrementID++;
               System.out.println("Todo Berhasil Ditambahkan");
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean edit(int id, String title, String description) {
        for(ToDo ToDo : db.Todo) {
            if(ToDo.id == id) {
                ToDo.title = title;
                ToDo.description = description;
                return true;
            }
        }
        return false;
    }

    public boolean destroy(int id) {
       for(ToDo ToDo : db.Todo) {
           if(ToDo.id == id) {
               db.Todo.remove(id-1);
               return true;
           }
       }
       return false;
    }
}