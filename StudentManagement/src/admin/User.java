package admin;

public class User {
    private final String userName;
    private final String passwords;

    public User(String name, String pass) {
        this.userName = name;
        this.passwords = pass;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWords() {
        return passwords;
    }
}