import java.util.ArrayList;

public class Restaurent {

    private String Name;
    private ArrayList<Menu> menus = new ArrayList<>(3);

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public String getName() {
        return Name;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public void setName(String name) {
        Name = name;
    }

    public void addDish(Dish dish,Menu menu){
        for(Menu menu1 : menus)
            if(menu1==menu)
                menu1.getDishes().add(dish);
    }

    public void removeDish(Dish dish){
        for(Menu menu1 : menus)
                menu1.getDishes().remove(dish);
    }

    public void updatePrice(int price,Dish dish, Menu menu){
        for(Menu menu1 : menus)
            if(menu1==menu)
                for(Dish dish1 : menu.getDishes())
                    if(dish==dish1)
                        dish1.setPrice(price);
    }

    public void displayMenu(){
        for(Menu menu1 : getMenus())
            System.out.println("Menu Name : " + menu1.getName());
    }

    public void addMenu(Menu menu){
        getMenus().add(menu);
    }
}
