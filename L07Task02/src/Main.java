public class Main {

    public static void main(String[] args){

        HourlyEmployee hourlyEmployee = new HourlyEmployee("Ajey" , 20190 , 0);
        System.out.println(hourlyEmployee.calculate_hourly_income(8));

        PermenantEmployee permenantEmployee = new PermenantEmployee("Alia" , 2910 , 0);
        System.out.println(permenantEmployee.calculate_hourly_income());

    }

}
