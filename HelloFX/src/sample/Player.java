package sample;

public class Player {

    private String name;
    private String identity;

    public String getIdentity() {
        return identity;
    }

    public String getName() {
        return name;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(String name){
        setName(name);
    }

}
