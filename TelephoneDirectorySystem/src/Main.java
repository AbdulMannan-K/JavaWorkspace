import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TelePhoneDirectory telePhoneDirectory = new TelePhoneDirectory(1);
        Scanner scanner = new Scanner(System.in);

        int choice;

        // Loop to show The Menu till User Wants to Exit

        do {
            System.out.print("Enter What you want to Do : \n1- Insert a new Contact\n2- Delete a Contact\n3- View Record/s \n4- Update a Record\n5- Sort Records \n6- Show Groups\n7- Show Recent BirthDays\n0- Exit : ");
             choice = scanner.nextInt();

            switch (choice) {
                case 0 -> System.exit(0);
                case 1 -> {
                    System.out.print("Enter Your First Name : ");
                    String name = scanner.next();
                    System.out.print("Enter Your Last Name : ");
                    String last = scanner.next();
                    System.out.print("Enter Your Phone Number : ");
                    String phone = scanner.next();
                    System.out.print("Enter Your Address : ");
                    String address = scanner.next();
                    System.out.println("Enter Your Country : ");
                    String country = scanner.next();
                    System.out.print("Enter Your City : ");
                    String city = scanner.next();
                    System.out.print("Enter Your Website : ");
                    String website = scanner.next();
                    System.out.print("Enter Your Mobile : ");
                    String mobile = scanner.next();
                    System.out.print("Enter Your Company : ");
                    String company = scanner.next();
                    System.out.print("Enter Your BirthDay : ");
                    int day = scanner.nextInt();
                    System.out.print("Enter Your BirthMonth : ");
                    int month = scanner.nextInt();
                    System.out.print("Do you Want to : \n1- No Group\n2- Join Group\n3- Make Group : ");
                    int choice1 = scanner.nextInt();
                    String group = null;
                    switch (choice1) {
                        case 1 -> group = "NuN";
                        case 2 -> {
                            System.out.print("Enter Group Name you want to associate with : ");
                            group = scanner.next();
                        }
                        case 3 -> {
                            System.out.print("Enter Group Name : ");
                            group = scanner.next();
                        }
                    }
                    Contact contact = new Contact(name, last, phone, address, city, country, website, mobile, company, group, day, month);
                    telePhoneDirectory.insertRecord(contact);
                }
                case 2 -> {
                    System.out.print("Do You want to \n1- Enter ID \n2- Enter Full Name : ");
                    int choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1 -> {
                            System.out.print("Enter your ID : ");
                            telePhoneDirectory.deleteRecord(scanner.nextInt());
                        }
                        case 2 -> {
                            System.out.print("Enter your Full Name(Without Space) : ");
                            telePhoneDirectory.deleteRecord(scanner.next());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Do You Want to find \n1- Specific Records by First Name \n2- All Records : ");
                    int choice1 = scanner.nextInt();
                    switch (choice1) {
                        case 1 -> {
                            System.out.print("Enter First Name : ");
                            String firstName = scanner.next();
                            int index = telePhoneDirectory.searchByFirstName(firstName, 0, telePhoneDirectory.Contacts().length);
                            if(index==-1)
                                break;
                            System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s  %-30.30s%n\n", "ID", "Name", "Group", "Phone Number", "Address", "City", "Country", "Mobile", "Company", "Website");
                            System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n\n", telePhoneDirectory.Contacts()[index].getId(), telePhoneDirectory.Contacts()[index].getName() + telePhoneDirectory.Contacts()[index].getLastName(), telePhoneDirectory.Contacts()[index].getGroupName(), telePhoneDirectory.Contacts()[index].getPhoneNumber(), telePhoneDirectory.Contacts()[index].getAddress(), telePhoneDirectory.Contacts()[index].getCity(), telePhoneDirectory.Contacts()[index].getCountry(), telePhoneDirectory.Contacts()[index].getMobile(), telePhoneDirectory.Contacts()[index].getCompany(), telePhoneDirectory.Contacts()[index].getWebsite());

                            for (int i = 0; i < index; i++) {
                                if (telePhoneDirectory.Contacts()[i].getName().equals(firstName))
                                    System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n\n", telePhoneDirectory.Contacts()[index].getId(), telePhoneDirectory.Contacts()[index].getName() + telePhoneDirectory.Contacts()[index].getLastName(), telePhoneDirectory.Contacts()[index].getGroupName(), telePhoneDirectory.Contacts()[index].getPhoneNumber(), telePhoneDirectory.Contacts()[index].getAddress(), telePhoneDirectory.Contacts()[index].getCity(), telePhoneDirectory.Contacts()[index].getCountry(), telePhoneDirectory.Contacts()[index].getMobile(), telePhoneDirectory.Contacts()[index].getCompany(), telePhoneDirectory.Contacts()[index].getWebsite());
                                else
                                    break;
                            }
                            for (int i = index; i < telePhoneDirectory.Contacts().length; i++) {
                                if (telePhoneDirectory.Contacts()[i].getName().equals(firstName))
                                    System.out.printf("\n\t\t%-30.30s %-30.30s %-30.30s  %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n\n", telePhoneDirectory.Contacts()[index].getId(), telePhoneDirectory.Contacts()[index].getName() + telePhoneDirectory.Contacts()[index].getLastName(), telePhoneDirectory.Contacts()[index].getGroupName(), telePhoneDirectory.Contacts()[index].getPhoneNumber(), telePhoneDirectory.Contacts()[index].getAddress(), telePhoneDirectory.Contacts()[index].getCity(), telePhoneDirectory.Contacts()[index].getCountry(), telePhoneDirectory.Contacts()[index].getMobile(), telePhoneDirectory.Contacts()[index].getCompany(), telePhoneDirectory.Contacts()[index].getWebsite());
                                else
                                    break;
                            }
                        }
                        case 2 -> telePhoneDirectory.viewRecords();
                    }
                }
                case 4 -> {
                    System.out.print("Enter your Full Name : ");
                    String name = scanner.next();
                    System.out.print("Enter What You want to update : \n1- First Name\n2- Last Name\n3- Phone Number \n4- Address \n5- City \n6- Country : ");
                    telePhoneDirectory.updateRecord(name, scanner.nextInt());
                }
                case 5 -> telePhoneDirectory.sortRecords();
                case 6 -> {
                    System.out.print("Enter Group Name : ");
                    telePhoneDirectory.showGroup(scanner.next());
                }
                case 7 -> telePhoneDirectory.recentBirthdays();

            }
        }while (true);

    }

}
