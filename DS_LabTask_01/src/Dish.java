import java.util.Random;

public class Dish {

    private String name;
    private int price;
    int id;


    public int getId() {
        return id;
    }

    public void setId() {
        Random random = new Random();
        this.id = random.nextInt();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Dish(String name ,int price){
        this.name=name;
        this.price=price;
        setId();
    }
}
