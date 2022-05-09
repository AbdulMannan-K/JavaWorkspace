public class Faculty extends Employee{

    private int officeHours;
    private String rank;

    public Faculty(String name, String phone, String adress, String mail, double salary, String startDate,int officeHours,String rank) {
        super(name, phone, adress, mail, salary, startDate);
        this.officeHours=officeHours;
        this.rank=rank;
    }

    public void setOfficeHours(int officeHours) {
        this.officeHours = officeHours;
    }

    public int getOfficeHours() {
        return officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }
}
