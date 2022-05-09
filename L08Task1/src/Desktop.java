public class Desktop extends Computer{
    private String color;
    private int MonitorSize;
    private String processorType;

    Desktop(){
        this("Black" , 42  , "i7");
    }
    Desktop(String color, int MonitorSize , String processorType){
        this.color= color;
        this.MonitorSize= MonitorSize;
        this.processorType=processorType;
    }

    void show(){
        System.out.println("Company Name is : " + CompanyName + "\nPrice is : " + price + "\nColor is : " + color +"\nMonitor Size is " + MonitorSize +"\nProcessor type is : " + processorType);
    }
}
