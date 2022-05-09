public class Student extends Person{

    private boolean isRegistered;

    public Student(String name , String phone, String adress, String mail, boolean isRegistered){
        super(name,phone,adress,mail);
        this.isRegistered=isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isRegistered() {
        return isRegistered;
    }
}
