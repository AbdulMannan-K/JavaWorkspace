public class Staff extends Employee{

    private String title;

    public Staff(String name, String phone, String adress, String mail, double salary, String startDate,String title) {
        super(name, phone, adress, mail, salary, startDate);
        this.title=title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
