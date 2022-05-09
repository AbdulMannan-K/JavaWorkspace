package Models;

import java.util.ArrayList;

public class Group {

    private ArrayList<Record> groups = new ArrayList<>();
    private int gap;

//    public Group(int gap){
//        setGap(gap);
//    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public void setGroups(ArrayList<Record> groups) {
        this.groups = groups;
    }

    public ArrayList<Record> getGroups() {
        return groups;
    }
}
