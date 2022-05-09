public class Client {

    public static void main(String[] args) {
        // As the Data generator was not necessary , Just tested it with random objects
        OrderProcessor orderProcessor = new OrderProcessor();
        GenericOrder<Product> p = new GenericOrder<>();
        p.addProduct(new RAM("DDR2",12,1333));
        p.addProduct(new RAM("DDR4",12,1333));
        p.addProduct(new Monitor("1090p",12123));
        p.addProduct(new AssemblyService("service1",12123));
        p.addProduct(new Apple(12123));
        orderProcessor.accept(p);
        orderProcessor.process();
        orderProcessor.dispatchComputerParts();
        orderProcessor.dispatchPartyTray();

        // As the Data generator was not necessary , Just tested it with random objects
        //part 2
        OrderProcessor orderProcessor1 = new OrderProcessor();
        GenericOrder<Product> p1 = new ComputerPartyOrder();
        p1.addProduct(new Cheese(12));
        orderProcessor1.accept(p1);
        orderProcessor1.process();
        orderProcessor1.dispatchPartyTray();

    }

}
