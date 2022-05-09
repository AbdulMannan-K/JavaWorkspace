import java.util.ArrayList;
import java.util.Random;

public class GenericOrder<T extends Product> {
    private final int id;
    private final ArrayList<T> items;

    public GenericOrder() {
        id = new Random().nextInt(9232134);
        items = new ArrayList<>();
    }

    protected void addProduct(T item) {
        items.add(item);
    }

    protected void removeProduct(T item) {
        items.remove(item);
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public int getId() {
        return id;
    }
}

class ComputerOrder extends GenericOrder<Product> {
    public void addComputerPart(ComputerPart item) {
        super.addProduct(item);
    }

    public void addPeripheral(Peripheral item) {
        super.addProduct(item);
    }

    public void addService(Service item) {
        super.addProduct(item);
    }

    public void removeComputerPart(ComputerPart item) {
        super.removeProduct(item);
    }

    public void removePeripheral(Peripheral item) {
        super.removeProduct(item);
    }

    public void removeService(Service item) {
        super.removeProduct(item);
    }

    public static <T extends Product> String nameResolver(T computerPart) {
        if (computerPart instanceof RAM) return ((RAM) computerPart).manufacturer;
        if (computerPart instanceof Motherboard) return ((Motherboard) computerPart).manufacturer;
        if (computerPart instanceof Drive) return ((Drive) computerPart).type;
        if (computerPart instanceof Monitor) return ((Monitor) computerPart).model;
        if (computerPart instanceof Printer) return ((Printer) computerPart).model;
        if (computerPart instanceof DeliveryService) return ((DeliveryService) computerPart).courier;
        if (computerPart instanceof AssemblyService) return ((AssemblyService) computerPart).provider;

        return null;
    }
}

class PartyTrayOrder extends GenericOrder<Product> {
    public void addCheese(Cheese item) {
        super.addProduct(item);
    }

    public void addFruits(Fruit item) {
        super.addProduct(item);
    }

    public void deleteCheese(Cheese item) {
        super.removeProduct(item);
    }

    public void deleteFruit(Fruit item) {
        super.removeProduct(item);
    }

    public static <T extends Product> String nameResolver(T thing) {
        if (thing instanceof Apple) return "Apple";
        if (thing instanceof Cheddar) return "Cheddar";
        if (thing instanceof Orange) return "Orange";
        if (thing instanceof Mozzarella) return "Mozzarella";

        return null;
    }

}
    class ComputerPartyOrder extends GenericOrder<Product> {
        public void addComputerPart(ComputerPart item) {
            super.addProduct(item);
        }

        public void removeComputerPart(ComputerPart item) {
            super.removeProduct(item);
        }

        public void addPeripheral(Peripheral item) {
            super.addProduct(item);
        }

        public void removePeripheral(Peripheral item) {
            super.removeProduct(item);
        }
        public void addCheese(Cheese item) {
            super.addProduct(item);
        }

        public void addFruits(Fruit item) {
            super.addProduct(item);
        }

        public void deleteCheese(Cheese item) {
            super.removeProduct(item);
        }

        public void deleteFruit(Fruit item) {
            super.removeProduct(item);
        }

        public void addService(Service item) {
            super.addProduct(item);
        }

        public void removeService(Service item) {
            super.removeProduct(item);
        }

        public static <T extends Product> String nameResolver(T Part) {
            if (Part instanceof Apple) return "Apple";
            if (Part instanceof Cheddar) return "Cheddar";
            if (Part instanceof Orange) return "Orange";
            if (Part instanceof Mozzarella) return "Mozzarella";
            if (Part instanceof RAM) return ((RAM) Part).manufacturer;
            if (Part instanceof Motherboard) return ((Motherboard) Part).manufacturer;
            if (Part instanceof Drive) return ((Drive) Part).type;
            if (Part instanceof Monitor) return ((Monitor) Part).model;
            if (Part instanceof Printer) return ((Printer) Part).model;
            if (Part instanceof DeliveryService) return ((DeliveryService) Part).courier;
            if (Part instanceof AssemblyService) return ((AssemblyService) Part).provider;
            return null;
        }
    }
