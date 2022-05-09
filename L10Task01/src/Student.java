public class Student {
    private String rollNo,name;
    private double gpa;int sem_count;

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setSem_count(int sem_count) {
        this.sem_count = sem_count;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public int getSem_count() {
        return sem_count;
    }

    public String getRollNo() {
        return rollNo;
    }



    Student(String rollNo,String name, double gpa , int sem_count){
        setGpa(gpa);
        setName(name);
        setSem_count(sem_count);
        setRollNo(rollNo);
    }
}
