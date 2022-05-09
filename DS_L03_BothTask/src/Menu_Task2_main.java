import java.util.Scanner;

public class Menu_Task2_main {

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        CustomArrayList<Contact> contacts = new CustomArrayList<>(1);

        do{
            System.out.print("1- Add a new Contact\n2- Display All Accounts\n3- Display specific contact\n4- Delete a contact\n5- Quit  : ");
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> {
                    System.out.print("Enter First Name : " );
                    String first = scanner.next();
                    System.out.print("Enter Last Name : ");
                    String last = scanner.next();
                    System.out.print("Enter Phone Number : ");
                    String phone = scanner.next();
                    System.out.print("Enter Email Adress : ");
                    contacts.add(new Contact(first,last,phone,scanner.next()));
                }
                case 2 -> {
                    for(int i=0 ; i < contacts.getArray().length ; i++){
                        Contact contact = (Contact) contacts.getArray()[i];
                        System.out.println("Name : " + contact.getFirstName()+contact.getLastName() + "\nPhone : " + contact.getPhoneNumber());
                    }
                }
                case 3 -> {
                    System.out.print("Enter Phone Number : ");
                    String phone = scanner.next();
                    for(int i=0 ; i < contacts.getArray().length ; i++){
                        Contact contact = (Contact) contacts.getArray()[i];
                        if(contact.getPhoneNumber().equals(phone)){
                            System.out.println("Name : " + contact.getFirstName()+contact.getLastName() + "\nPhone : " + contact.getPhoneNumber());
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Enter Phone Number : ");
                    String phone = scanner.next();
                    for(int i=0 ; i < contacts.getArray().length ; i++){
                        Contact contact = (Contact) contacts.getArray()[i];
                        if(contact.getPhoneNumber().equals(phone)){
                            contacts.remove(contact);
                            break;
                        }
                    }
                }
                case 5 -> {
                    System.exit(0);
                }
            }
        }while (true);
    }

}
