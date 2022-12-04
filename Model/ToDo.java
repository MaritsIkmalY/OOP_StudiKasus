package Model;

public class ToDo {
    public int id ;
    public int owner_id;
    public String title;
    public String description;

    public ToDo(int id,int owner_id, String title, String description) {
        this.id = id;
        this.owner_id = owner_id;
        this.title = title;
        this.description = description;
    }
}