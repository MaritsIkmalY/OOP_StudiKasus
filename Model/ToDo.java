package Model;

public class ToDo {
    private final int id;
    private final int user_id;
    private String title;
    private String description;

    public ToDo(int id, int user_id, String title, String description) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//    public static class ToDoBuilder {
//        private final int id;
//        private final int owner;
//        private String title;
//        private String description;
//
//        public ToDoBuilder(int id, int owner) {
//            this.id = id;
//            this.owner = owner;
//        }
//
//        public ToDoBuilder title(String title) {
//            this.title = title;
//            return this;
//        }
//
//        public ToDoBuilder description(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public ToDo build() {
//            return new ToDo(this);
//        }
//    }
}

