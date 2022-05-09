public class Person {

    protected String name;
    protected String adress;
    protected String phoneNumber;
    protected String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person(String name , String phone, String adress, String mail) {
        this.name = name;
        this.adress = adress;
        this.email = mail;
        this.phoneNumber = phone;
    }
}
