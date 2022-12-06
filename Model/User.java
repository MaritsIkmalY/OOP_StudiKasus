package Model;

public record User(int id, String name, String username, String password, String phone, String address) {
    @Override
    public String toString() {
        return  "Name : " + name + '\n' +
                "Username : " + username + '\n' +
                "Password : " + password + '\n' +
                "Phone : " + phone + '\n' +
                "Address : " + address + '\n';
    }
}

