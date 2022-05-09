public class Emplyee {
    protected String firstName;
    protected String lastName;
    protected String CNIC;

    public String getCNIC() {
        return CNIC;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    Emplyee(String firstName , String lastName , String CNIC){
        setCNIC(CNIC);
        setFirstName(firstName);
        setLastName(lastName);
    }

    Emplyee(){
        this( "Abdul" , "Mannan" , "611012323434");
    }

    public double earnings(){
        return 0.00;
    }
}
