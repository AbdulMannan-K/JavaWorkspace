import java.util.ArrayList;
public class OrderProcessor {
    private final ArrayList<GenericOrder<Product>> orders = new ArrayList<>();

    private ArrayList<OrderItem<Fruit>> fruits = new ArrayList<>();
    private ArrayList<OrderItem<Cheese>> cheese = new ArrayList<>();
    private ArrayList<OrderItem<Service>> services = new ArrayList<>();
    private final ArrayList<OrderItem<Peripheral>> peripherals = new ArrayList<>();
    private final ArrayList<OrderItem<ComputerPart>> computerParts = new ArrayList<>();

    public void accept(GenericOrder<Product> order) {
        orders.add(order);
    }

    public void process() {
        computerParts.clear();
        peripherals.clear();
        services.clear();
        cheese.clear();
        fruits.clear();

        for (final var order : orders) {
            for (final var item : order.getItems()) {
                if (item instanceof ComputerPart) {
                    computerParts.add(new OrderItem<>(order.getId(), (ComputerPart) item));
                } else if (item instanceof Peripheral) {
                    peripherals.add(new OrderItem<>(order.getId(), (Peripheral) item));
                } else if (item instanceof Service) {
                    services.add(new OrderItem<>(order.getId(), (Service) item));
                } else if (item instanceof Cheese) {
                    cheese.add(new OrderItem<>(order.getId(), (Cheese) item));
                } else if (item instanceof Fruit) {
                    fruits.add(new OrderItem<>(order.getId(), (Fruit) item));
                }
            }
        }
    }

    public void dispatchComputerParts() {
        dispatch(computerParts, ComputerOrder::nameResolver);
        dispatch(peripherals,ComputerOrder::nameResolver);
        dispatch(services,ComputerOrder::nameResolver);
    }

    public void dispatchPartyTray() {
        dispatch(fruits, PartyTrayOrder::nameResolver);
        dispatch(cheese, PartyTrayOrder::nameResolver);
    }

    private static <T extends Product> void dispatch(ArrayList<OrderItem<T>> items, NamePrinter printer) {
        for (final var item : items) {
            final var prod = item.item;
            System.out.println(prod.getClass().getName() + " name=" + printer.print(prod) + ", price=" + prod.price + ", order number=" + item.id);
        }
    }
}

interface NamePrinter {
    <T extends Product> String print(T product);
}
