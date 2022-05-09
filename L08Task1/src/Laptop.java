public class Laptop extends Computer{
    private String color;
    private int MonitorSize;
    private int weight;
    private String processorType;

    Laptop(){
        this("Blue" , 32 , 20 , "i5");
    }
    Laptop(String color, int MonitorSize , int weight , String processorType){
        this.color= color;
        this.MonitorSize= MonitorSize;
        this.weight = weight;
        this.processorType=processorType;
    }

    void show(){
        System.out.println("Company Name is : " + CompanyName + "\nPrice is : " + price + "\nColor is : " + color +"\nMonitor Size is " + MonitorSize + "\nWeight is : " + weight + "\nProcessor type is : " + processorType);
    }

}
