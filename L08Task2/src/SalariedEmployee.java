public class SalariedEmployee extends Emplyee{
    private double weeklySalary;

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if(weeklySalary<0)
            System.out.println("Value less than zero try again");
        else
            this.weeklySalary = weeklySalary;
    }

    SalariedEmployee(String first , String last , String CNIC , double weeklySalary){
        super(first,last,CNIC);
        setWeeklySalary(weeklySalary);
    }
    SalariedEmployee(double weeklySalary){
        setWeeklySalary(weeklySalary);
    }
    SalariedEmployee(){
        this(1000);
    }

    public double earnings() {
        return getWeeklySalary();
    }
}
