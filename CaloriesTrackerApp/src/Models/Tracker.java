package Models;

import Data.DataHandle;

import java.util.ArrayList;
import java.util.Random;

public class Tracker {

    private int id;
    private User user;
    private ArrayList<Item> items = new ArrayList<>();

    public Tracker(User user){
        setUser(user);
        setId();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId() {
        Random random = new Random();
        boolean isRepeat = false;
        do {
            this.id = random.nextInt(10000);
            for (User user : DataHandle.users) {
                if (user.getTracker().getId() == id){
                    isRepeat=true;
                    break;
                }
            }
        }while (isRepeat);
    }

    public void setId(int id) {
        this.id =id;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
