import java.util.ArrayList;

public class Menu {

    private String name;
    private ArrayList<Dish> dishes;

    public String getName() {
        return name;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDishes(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }

    public Menu(String name){
        this.name=name;
        dishes = new ArrayList<>();
    }
}
