package Models;

public class User {

    private String name;
    private String password;
    private Tracker tracker;

    public User(String name, String password){
        setName(name);
        setPassword(password);
        tracker = new Tracker(this);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }
}
