public class vision {
    private double flength;
    private double fwidth;
    private int length;
    private int width;

    public void setLength(int length){
        this.length=length;
    }
    public void setFlength(double flength){
        this.flength =flength;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public void setFwidth(double fwidth){
        this.fwidth=fwidth;
    }

    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    public double getFlength(){
        return flength;
    }
    public double getFwidth(){
        return fwidth;
    }

    vision(){
        setWidth(10) ; setFwidth(10.5);
        setLength(12); setFlength(12.43);
        int area = calArea();
        int price = calPrice();
        display(area,price);
    }
    vision(int length,int width){
        setLength(length);
        setWidth(width);
        int area = calArea();
        int price = calPrice();
        display(area,price);
    }
    vision(double flength, double fwidth){
        setFlength(flength);
        setFwidth(fwidth);
        double area = calfArea();
        double price = calfPrice();
        display(area, price);
    }
    vision(int length){
        setLength(length);
        setWidth(10);
        int area = calArea();
        int price = calPrice();
        display(area,price);
    }

    private int calArea(){
        return getLength()*getWidth();
    }

    private double calfArea(){
        return getFlength()*getFwidth();
    }

    private int calPrice(){
        return getLength()*getWidth()*65;
    }

    private double calfPrice(){
        return getFlength()*getFwidth()*65;
    }

    private void display(int area,int price){
        System.out.println("The area of your TV is :" + area);
        System.out.println("The price of your TV is :" + price);
    }

    private void display(double area,double price){
        System.out.println("The area of your TV is :" + area);
        System.out.println("The price of your TV is :" + price);
    }


}
