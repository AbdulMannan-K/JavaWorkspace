public class Employee extends Person{

    private double salary;
    private String startDate;

    public Employee(String name , String phone, String adress, String mail,double salary, String startDate){
        super(name,phone,adress,mail);
        this.salary=salary;
        this.startDate=startDate;
    }

    public double getSalary() {
        return salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
