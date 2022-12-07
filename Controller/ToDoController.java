package Controller;

import Model.ToDo;

import java.util.ArrayList;

public class ToDoController {
    public ArrayList<ToDo> todos;
    public int incrementId = 1;

    public ToDoController(ArrayList<ToDo> todos) {
        this.todos = todos;
    }

    public ArrayList<ToDo> getAllTodos() {
        return todos;
    }

    public void store(int user_id, String owner, String title, String description) {
        try {
            if (todos.add(new ToDo(incrementId, user_id, owner, title, description))) {
                incrementId++;
                System.out.println("Todo Berhasil Ditambahkan !");
            }
        } catch (Exception e) {
            System.out.println("Something Error !!" + e);
        }
    }

    public void edit(int id, int user_id, String title, String description) {
        ToDo todo = validate(id, user_id);
        if (todo != null) {
            if (title != null && !title.trim().isEmpty()) {
                todo.setTitle(title);
            }

            if (description != null && !description.trim().isEmpty()) {
                todo.setDescription(description);
            }
            todo.setLast_updated();
            System.out.println("Todo List berhasil di edit!");
        } else {
            System.out.println("Todo List gagal di edit!");
        }

    }

    public void destroy(int id, int user_id) {
        ToDo todo = validate(id, user_id);

        if (todo != null) {
            todos.remove(todo);
            System.out.println("Todo List berhasil dihapus!");
        } else {
            System.out.println("Todo List gagal dihapus!");
        }
    }

    public ToDo validate(int id, int user_id) {
        for (ToDo todo : todos) {
            if (todo.getId() == id && todo.getUser_id() == user_id) {
                return todo;
            }
        }
        return null;
    }

}