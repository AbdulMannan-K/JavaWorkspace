/**
 * Contact is One record(entity)(Subscriber) of telephone service
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String country;
    private String address;
    private String website;
    private String mobile;
    private String company;
    private String groupName;
    private int birthDay;
    private int birthMonth;
    private static int idToPut=1;

    /**
     * Constructor to initialize Contact
     */
    public Contact(String firstName, String lastName,String phoneNumber,String address,String city,String country,String website,String mobile,String company,String groupName,int birthDay,int birthMonth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
        this.website=website;
        this.mobile = mobile;
        this.company=company;
        this.groupName=groupName;
        this.birthMonth=birthMonth;
        this.birthDay=birthDay;
        /** ID is auto generated , first come first get basis */
        setId(idToPut++);
    }


    /**
     * Getters Setters of Entities
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWebsite() {
        return website;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }
}


