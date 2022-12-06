package Model;

public class User {
    private final int id;
    private final String name;
    private final String username;
    private final String password;
    private final String phone;
    private final String address;

    public User(int id, String name, String username, String password, String phone, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public String name() {
        return name;
    }

    public String username() {
        return username;
    }

    public int id() {
        return id;
    }

    @Override
    public String toString() {
        return  "Id : " + id + '\n' +
                "Name : " + name + '\n' +
                "Username : " + username + '\n' +
                "Password : " + password + '\n' +
                "Phone : " + phone + '\n' +
                "Address : " + address + '\n';
    }
}

