public class CommisionEmployee extends Emplyee{

    private double grossSales;
    private double commissionRate;

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if(commissionRate<0)
            System.out.println("Value less than zero try again");
        else
            this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        if(grossSales<0)
            System.out.println("Value less than zero try again");
        else
            this.grossSales = grossSales;
    }

    CommisionEmployee(String first , String last , String CNIC ,double grossSales, double commissionRate){
        super(first,last,CNIC);
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    CommisionEmployee(double grossSales, double commissionRate){
        setGrossSales(grossSales);
        setCommissionRate(commissionRate);
    }

    CommisionEmployee(){
        this(12,23.33);
    }

    public double earnings() {
        return getGrossSales()*commissionRate;
    }
}
