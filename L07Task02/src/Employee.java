public class Employee {

    protected String name;
    protected int empId;

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    Employee(String name , int empId){
        setEmpId(empId);
        setName(name);
    }
}
