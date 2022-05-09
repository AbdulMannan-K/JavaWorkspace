public class HourlyEmployee extends Employee{

    private int hourlyIncome;

    HourlyEmployee(String name, int empId , int hourlyIncome) {
        super(name, empId);
        setHourlyIncome(hourlyIncome);
    }

    public void setHourlyIncome(int hourlyIncome) {
        this.hourlyIncome = hourlyIncome;
    }

    public int getHourlyIncome() {
        return hourlyIncome;
    }

    int calculate_hourly_income(int hours){
        for(int i=0 ; i < hours ; i++)
            setHourlyIncome(getHourlyIncome()+150);
        return getHourlyIncome();
    }


}
