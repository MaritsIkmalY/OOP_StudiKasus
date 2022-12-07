package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToDo {
    private final int id; //unique
    private final int user_id;
    private final String owner;
    private final String created_at;
    private String title;
    private String description;
    private String last_updated = "-";

    public ToDo(int id, int user_id,String owner, String title, String description) {
        this.id = id;
        this.user_id = user_id;
        this.owner = owner;
        this.title = title;
        this.description = description;
        this.created_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy hh:mm"));
    }


    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOwner() {
        return owner;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLast_updated() {
        this.last_updated = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy hh:mm"));
    }


}

