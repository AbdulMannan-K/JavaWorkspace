import java.time.LocalDate;
import java.util.Scanner;

/**
 * TelePhone Directory is a Class representing a Telephone Service
 */
public class TelePhoneDirectory {

    // Contacts are Basically Subscribers of This Service
    private Contact[] contacts;
    // Current Index to know that which index is currently on Array so we can know where to add next Contact
    private int currentIndex;

    /**
     * Constructor To initialize Array and Current Index
     * @param initialSize is if user wants a initial specific size for array
     */
    public TelePhoneDirectory(int initialSize){
        contacts=new Contact[initialSize];
        currentIndex=0;
    }

    /**
     * By Default Three size is given to Array
     */
    public TelePhoneDirectory(){
        contacts=new Contact[3];
    }

    /**
     * Insert Record adds the Subscribers in Array
     * @param contact is the contact to add in array(Telephone Directory) to become a subscriber
     */
    public void insertRecord(Contact contact){
        // Check if Array Size is alright or has the Array Size gone less
        // if Array size has gone less then it would increase Array Size
        if(currentIndex >= contacts.length-1)
            increaseSizeOfArray();

        contacts[currentIndex]=contact;
        currentIndex++;
    }

    /**
     * Function(Method) to increase the size of Array if Size has gone less
     */
    public void increaseSizeOfArray(){
        Contact[] tempContacts = new Contact[currentIndex+1];
        System.arraycopy(contacts, 0, tempContacts, 0, contacts.length);
        contacts=tempContacts;
    }

    /**
     * deleteRecord deletes a record from Data and decrease the size of Array
     * @param toFind Name or Id to be found
     * @param <T> Generic bcz T can be String or Integer
     */
    public<T> void deleteRecord(T toFind){

        int indexOfRecord ;

        // Find The index Which has to be deleted by Binary Search
        if (toFind instanceof String)
            indexOfRecord=searchRecord((String) toFind, 0, contacts.length);
        else
            indexOfRecord=searchRecord((Integer) toFind, 0, contacts.length);

        // If the record is not found
        if(indexOfRecord == -1)
            System.out.println("\nRecord Not Found\n");
        else{
            for(int i=indexOfRecord+1 ; i < contacts.length ; i++,indexOfRecord++){
                contacts[indexOfRecord]=contacts[i];
            }

            decreaseSizeOfArray();
            currentIndex--; // decrease the current index as the size is decreased
        }

    }

    /**
     * Method to decrease the Size of Array
     */
    public void decreaseSizeOfArray(){
        Contact[] tempContacts = new Contact[currentIndex-1];
        System.arraycopy(contacts, 0, tempContacts, 0, tempContacts.length);
        contacts=tempContacts;
    }

    /**
     * Method to view All Records in TelePhone Directory
     */
    public void viewRecords(){

        System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s  %-30.30s%n\n", "ID" ,"Name", "Group" , "Phone Number" , "Address" , "City" , "Country" , "Mobile" , "Company" , "Website");

        for(int i=0 ; i < contacts.length ; i++)
            System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n\n", contacts[i].getId() , contacts[i].getName()+contacts[i].getLastName(), contacts[i].getGroupName(),contacts[i].getPhoneNumber() , contacts[i].getAddress() , contacts[i].getCity() , contacts[i].getCountry() , contacts[i].getMobile(), contacts[i].getCompany(),contacts[i].getWebsite());

    }

    /**
     * Updates The Record
     * @param name to Find the Index of Array to Manipulate
     * @param updateType to check which entity of Contact to Update
     */
    public void updateRecord(String name , int updateType){

        Scanner scanner = new Scanner(System.in);

        int index = searchRecord(name,0,contacts.length);

        if(index==-1){
            System.out.println("\nContact not found\n");
            return;
        }

        Contact contact = contacts[index];

        switch(updateType){
            case 1-> {
                System.out.print("Enter New First Name : ");
                contact.setName(scanner.next());
            }
            case 2-> {
                System.out.print("Enter New Last Name : ");
                contact.setLastName(scanner.next());
            }
            case 3-> {
                System.out.print("Enter New Phone Number : ");
                contact.setPhoneNumber(scanner.next());
            }
            case 4-> {
                System.out.print("Enter New Address (without spaces) : ");
                contact.setAddress(scanner.next());
            }
            case 5-> {
                System.out.println("Enter New City : ");
                contact.setCity(scanner.next());
            }
            case 6-> {
                System.out.print("Enter New Country : ");
                contact.setCountry(scanner.next());
            }
        }

    }

    /**
     * Method to Show Records Connected to Specific Group
     * @param groupName to Check Which Records are connected to specific Group
     */
    public void showGroup(String groupName){
        System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s  %-30.30s%n\n", "ID" ,"Name", "Group" , "Phone Number" , "Address" , "City" , "Country" , "Mobile" , "Company" , "Website");

        for(int i = 0 ; i < contacts.length ; i++){
            if(contacts[i].getGroupName()!=null&&contacts[i].getGroupName().equalsIgnoreCase(groupName)){
                System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n\n", contacts[i].getId() , contacts[i].getName()+contacts[i].getLastName(), contacts[i].getGroupName(),contacts[i].getPhoneNumber() , contacts[i].getAddress() , contacts[i].getCity() , contacts[i].getCountry() , contacts[i].getMobile(), contacts[i].getCompany(),contacts[i].getWebsite());
            }
        }
    }

    /**
     * Sort The Records By Bubble Sort
     */
    public void sortRecords(){

        for (int i = 0; i < contacts.length ; i++) {
            for (int j = 0; j < contacts.length - i - 1 ; j++) {
                if (contacts[j].getName().compareToIgnoreCase(contacts[j+1].getName()) > 0) {
                    Contact temp = contacts[j];
                    contacts[j] = contacts[j + 1];
                    contacts[j + 1] = temp;
                }
            }
        }

    }

    /**
     * Search The Records in Array By Binary Search
     * @param toFind to Find by The Full Name of Contact
     * @param startIndex To Calculate the mid
     * @param endIndex To Calculate the mid
     * @return index where Specific Contact is
     */
    public int searchRecord(String toFind,int startIndex, int endIndex){

        sortRecords();

        if(startIndex<endIndex){
            int midIndex = (endIndex+startIndex)/2;

            System.out.println(startIndex+" "+endIndex+" "+midIndex);

            if(toFind.compareToIgnoreCase(contacts[midIndex].getName()+contacts[midIndex].getLastName())==0)
                return midIndex;
            else if(toFind.compareToIgnoreCase(contacts[midIndex].getName()+contacts[midIndex].getLastName()) > 0) {
                return searchRecord(toFind, midIndex , endIndex);
            }
            else if(toFind.compareToIgnoreCase(contacts[midIndex].getName()+contacts[midIndex].getLastName()) < 0) {
                System.out.println("In here");
                return searchRecord(toFind, startIndex, midIndex );
            }

        }

        return -1;
    }

    /**
     * Search The Records in Array By Binary Search (Only Finds by First Name not Full Name)
     * @param toFind to Find by The First Name of Contact
     * @param startIndex To Calculate the mid
     * @param endIndex To Calculate the mid
     * @return index where Specific Contact is
     */
    public int searchByFirstName(String toFind,int startIndex, int endIndex){

        sortRecords();

        if(startIndex<endIndex){
            int midIndex = (endIndex+startIndex)/2;

            System.out.println(startIndex+" "+endIndex+" "+midIndex);

            if(toFind.compareToIgnoreCase(contacts[midIndex].getName())==0)
                return midIndex;
            else if(toFind.compareToIgnoreCase(contacts[midIndex].getName()) > 0) {
                return searchRecord(toFind, midIndex , endIndex);
            }
            else if(toFind.compareToIgnoreCase(contacts[midIndex].getName()) < 0) {
                return searchRecord(toFind, startIndex, midIndex );
            }

        }

        return -1;
    }

    /**
     * Search The Records in Array By Binary Searching The Ids
     * @param toFind to Find by The ID of Contact
     * @param startIndex To Calculate the mid
     * @param endIndex To Calculate the mid
     * @return index where Specific Contact is
     */
    public int searchRecord(int toFind,int startIndex, int endIndex){

        if(startIndex<=endIndex){
            int midIndex = (endIndex+startIndex)/2;

            if(toFind == (contacts[midIndex].getId()))
                return midIndex;
            else if(toFind > (contacts[midIndex].getId())) {
                return searchRecord(toFind, midIndex+1 , endIndex);
            }
            else if(toFind < (contacts[midIndex].getId())) {
                return searchRecord(toFind, startIndex, midIndex-1 );
            }

        }

        return -1;
    }

    /**
     * To Show The Recent BirthDays of Contacts in Telephone Directory
     */
    public void recentBirthdays(){
        LocalDate myDate = LocalDate.now();
        String date = myDate.toString();
        int month = Integer.parseInt(date.substring(5,6));
        int day = Integer.parseInt(date.substring(9,10));
        for(int i=0 ; i < contacts.length ; i++){
            int dayy = ( contacts[i].getBirthDay()-day);
            if(dayy<0) dayy=dayy*-1;
            int monthh = (contacts[i].getBirthMonth()-month);
            if(monthh<0) monthh=monthh*-1;
            System.out.println("User Name : " + contacts[i].getName()+contacts[i].getLastName() + " Birthday is " + monthh + " months away and " +dayy + " days away");
        }
    }

    /**
     * Getters Setters
     */

    public Contact[] Contacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }
}
