public class StudentRecord {
    private int id;
    private double CGPA;
    private int warning;

    public StudentRecord(int id, double cgpa, int warning) {
        this.id = id;
        this.CGPA=cgpa;
        this.warning=warning;
    }

    public double getCGPA() {
        return CGPA;
    }

    public double getWarning() {
        return warning;
    }

    public int getId() {
        return id;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public void setId(int id) {
        this.id = id;
    }
}
