import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Restaurent restaurent = new Restaurent();
        int choice;
        do {
            System.out.println("Enter 1- Add Menu\n2- Display Menu\n3- Add Dishes\n4- Remove Dishes\n5- Update Price of Dishes\n6-Display Dishes of Menu\n0- Exit : ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> System.exit(0);
                case 1 -> {
                    System.out.print("Enter Name of Menu (without space): ");
                    String name = scanner.next();
                    Menu menu = new Menu(name);
                    restaurent.addMenu(menu);
                }
                case 2 -> restaurent.displayMenu();
                case 3 -> {
                    System.out.println("Enter name of Menu you want to Enter Dishes in : ");
                    String name = scanner.next();
                    Menu desiredMenu = null;
                    for (Menu menu : restaurent.getMenus()) {
                        if (name.equals(menu.getName()))
                            desiredMenu = menu;
                    }
                    System.out.println("Enter name of Dish : ");
                    String dishName = scanner.next();
                    System.out.println("Enter price of Dish : ");
                    int price = scanner.nextInt();
                    Dish dish = new Dish(dishName, price);
                    restaurent.addDish(dish, desiredMenu);
                    System.out.println("Dish Created -> id = " + dish.getId());
                }
                case 4 -> {
                    System.out.println("Enter id of Dish : ");
                    int id = scanner.nextInt();
                    Dish desiredDish = null;
                    for(Menu menu : restaurent.getMenus()) {
                        for (Dish dish : menu.getDishes())
                            if (dish.getId()==(id))
                                desiredDish = dish;
                    }
                    restaurent.removeDish(desiredDish);
                }
                case 5 -> {
                    System.out.println("Enter name of Menu you want to Update Dishes in : ");
                    String name = scanner.next();
                    Menu desiredMenu = null;
                    for (Menu menu : restaurent.getMenus()) {
                        if (name.equals(menu.getName()))
                            desiredMenu = menu;
                    }
                    System.out.println("Enter name of Dish : ");
                    String dishName = scanner.next();
                    System.out.println("Enter new price of Dish : ");
                    int price = scanner.nextInt();
                    Dish desiredDish = null;
                    for (Dish dish : desiredMenu.getDishes())
                        if (dish.getName().equals(dishName))
                            desiredDish = dish;
                    restaurent.updatePrice(price, desiredDish, desiredMenu);
                }
                case 6->{
                    System.out.println("Enter name of Menu : ");
                    String name = scanner.next();
                    Menu desiredMenu = null;
                    for (Menu menu : restaurent.getMenus()) {
                        if (name.equals(menu.getName()))
                            desiredMenu = menu;
                    }
                    for (Dish dish : desiredMenu.getDishes())
                        System.out.println("Dish Name : " + dish.getName() + " Dish Price : " + dish.getPrice());
                }
            }

        }while (choice!=0);
    }

}
