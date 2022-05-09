public class Menus {

    public static void adminMenu(){
        System.out.println("Admin : ");
        System.out.println();
        System.out.print("Press 1 : Add Book.\n");
        System.out.println("Press 2 : Modify book record.");
        System.out.println("Press 3 : Delete a Book.");
        System.out.println("Press 4 : Issue Book.");
        System.out.println("Press 5 : View all available Books.");
        System.out.println("Press 6 : View the Record of Books issued overall");
        System.out.println("Press 7 : Change the Password.");
        System.out.println("Press 8 : View the record of given month.");
        System.out.println("Press 9 : Go back to general menu.");
    }

    public static void userMenu(){
        System.out.println("Student : ");
        System.out.println();
        System.out.println("Press 1 : Search a book.");
        System.out.println("Press 2 : Borrow a particular book.");
        System.out.println("Press 3 : Read a particular book.");
        System.out.println("Press 4 : Return Borrows Book.");
        System.out.println("Press 5 : Go back to general Menu");
    }

    public static void mainMenu(){
        System.out.println("Enter # : Switch to Admin Mode");
        System.out.println("Enter $ : Switch to Student Mode");
        System.out.println("Enter < : Exit");
    }

}
