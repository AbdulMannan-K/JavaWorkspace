import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        DictionaryTree tree = new DictionaryTree();
        char ch;
        do
        {
            System.out.println("\nActions :  \n");
            System.out.println("1. Insert ");
            System.out.println("2. search");
            System.out.println("3. Read from InOrder(File)");
            System.out.println("4. Read from PreOrder(File)");
            System.out.println("5. Read from PostOrder(File)");
            System.out.println("6. Write in InOrder(File)");
            System.out.println("7. Write in PreOrder(File)");
            System.out.println("8. Write in PostOrder(File)");
            System.out.println("9. Display in InOrder");
            System.out.println("10. Display in PreOrder");
            System.out.println("11. Display in PostOrder");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter Word to insert ( without space) ");
                    String word = scan.next();
                    System.out.println("Enter Meaning of Word");
                    scan.nextLine();
                    tree.insert( new DictionaryWord(word,scan.nextLine()) );
                    break;
                case 2 :
                    System.out.println("Enter Word to search ( without space)");
                    tree.Search(scan.next());
                    break;
                case 3 :
                    tree.RInOrder();
                    System.out.println("File Read Successfully");
                    break;
                case 4 :
                    tree.RPreOrder();
                    System.out.println("File Read Successfully");
                    break;
                case 5 :
                    tree.RPostOrder();
                    System.out.println("File Read Successfully");
                    break;
                case 6 :
                tree.WInOrder();
                System.out.println("File Wrote Successfully");
                break;
                case 7 :
                    tree.WPreOrder();
                    System.out.println("File Wrote Successfully");
                    break;
                case 8 :
                    tree.WPostOrder();
                    System.out.println("File Wrote Successfully");
                    break;
                case 9 :
                    tree.InOrder();
                    break;
                case 10 :
                    tree.PreOrder();
                    break;
                case 11 :
                    tree.PostOrder();
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }

}
