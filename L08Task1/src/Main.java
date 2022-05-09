public class Main {

    public static void main(String[] args){
        Computer computer = new Laptop();
        computer.show();

        System.out.println();

        Computer computer1 = new Desktop();
        computer1.show();
    }

}
