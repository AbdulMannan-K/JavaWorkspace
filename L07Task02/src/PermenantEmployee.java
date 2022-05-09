public class PermenantEmployee extends Employee{
    private int hourlyIncome;

    PermenantEmployee(String name, int empId , int hourlyIncome) {
        super(name, empId);
        setHourlyIncome(hourlyIncome);
    }

    public void setHourlyIncome(int hourlyIncome) {
        this.hourlyIncome = hourlyIncome;
    }

    public int getHourlyIncome() {
        return hourlyIncome;
    }

    int calculate_hourly_income(){
        for(int i=0 ; i < 24 ; i++)
            setHourlyIncome(getHourlyIncome()+150);
        return getHourlyIncome();
    }
}
