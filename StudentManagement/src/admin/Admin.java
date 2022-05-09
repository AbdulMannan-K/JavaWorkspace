package admin;

import data.io.Writer;

import java.util.ArrayList;

public class Admin {

    private static final ArrayList<User> users = new ArrayList<>();
    private static String user;
    private static final String key = "1234";

    private static final String admin = "Hassan";
    private static final ArrayList<String> pass = new ArrayList<>();

    static {
        pass.add("asdasd");
    }

    private static boolean unlock = false;

    public static String getAdmin() {
        return admin;
    }

    public static ArrayList<String> getPass() {
        return pass;
    }

    public static void add(User user) {
        users.add(user);
        Writer.addToQueue(user);
    }

    public static void remove(User user) {
        Writer.addToRemoveQueue(user);
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Admin.user = user;
    }

    public static boolean isUnlock() {
        return unlock;
    }

    public static void setUnlock(boolean unlock) {
        Admin.unlock = unlock;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static String getKey() {
        return key;
    }
}
