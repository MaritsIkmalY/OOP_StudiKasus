package Controller;

import Database.Db;
import Model.ToDo;

public class ToDoController {
    public Db db;
    public int incrementID = 1;

    public ToDoController(Db db) {
        this.db = db;
    }

    public void show() {
        System.out.println("====================");
        System.out.println("Show ToDo List");
        System.out.println("====================");
        System.out.println("id\tJudul\tDescription");
        for(ToDo ToDo : db.Todo) {
            System.out.print(" " + ToDo.id + "\t");
            System.out.print(ToDo.title + "\t");
            System.out.print(ToDo.description);
            System.out.println();
        }
    }

    public void store(String title, String description) {
        try {
           if( db.Todo.add(new ToDo(incrementID, title, description)) ) {
               incrementID++;
               System.out.println("Todo Berhasil Ditambahkan");
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void edit() {

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