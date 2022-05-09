import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Dictionary dictionary = start();

        System.out.println("Enter What you want to do : ");
        System.out.println("1- Insert word in Dictionary\n2- Delete Word in Dictionary");
        System.out.println("3- Search word in Dictionary\n4- Show Data in Pre-Order");
        System.out.println("5- Show Data in Post-Order\n6- Show Data in In-Order");
        System.out.println("7- Write Data in Pre-Order\n8- Write Data in Post-Order");
        System.out.println("9- Write Data in In-Order\n10- Read Data From File\n0- Exit");

        Scanner scan = new Scanner(System.in);
        int choice=0;
        do {
            if(choice>10 || choice < 0)
                System.out.println("Enter Choice in given Range 0-10 : ");
            choice = scan.nextInt();
        }while(choice>10 || choice < 0);

        while(choice!=0){
            switch(choice){
                case 1 ->{
                    System.out.println("Enter Word You want to Enter : ");
                    String word="a";
                    do{
                        if(!word.matches("^[a-zA-Z]*$"))
                            System.out.println("Enter a Word (a-z or A-Z) : ");
                        word = scan.next();
                    }while(!word.matches("^[a-zA-Z]*$"));
                    System.out.println("Enter Meaning You want to Enter : ");
                    scan.nextLine();
                    String meaning = scan.nextLine();
                    dictionary.insert(new Word(word,meaning));
                }
                case 2 -> {
                    System.out.println("Enter Word You want to Enter : ");
                    String word="a";
                    do{
                        if(!word.matches("^[a-zA-Z]*$"))
                            System.out.println("Enter a Word (a-z or A-Z) : ");
                        word = scan.next();
                    }while(!word.matches("^[a-zA-Z]*$"));
                    dictionary.delete(word);
                }
                case 3 -> {
                    System.out.println("Enter Word You want to Enter : ");
                    String word;
                    do{
                        word = scan.next();
                    }while(!word.matches("^[a-zA-Z]*$"));
                    dictionary.search(word);
                }
                case 4 -> dictionary.displayPreOrder();
                case 5 -> dictionary.displayPostOrder();
                case 6 -> {
                    dictionary.displayInOrder();
                    System.out.println(dictionary.i);
                }
                case 7 -> dictionary.writeFile(2);
                case 8 -> dictionary.writeFile(3);
                case 9 -> dictionary.writeFile(1);
                case 10 -> dictionary = start();
            }
            do {
                if(choice>10 || choice < 0)
                    System.out.println("Enter Choice in given Range 0-10 : ");
                System.out.println("Enter What you want to do : ");
                choice = scan.nextInt();
            }while(choice>10 || choice < 0);
        }

//        dictionary.displayPreOrder();
//        dictionary.search("qiwpepoq");
    }
    public static Dictionary start() throws IOException {
        Dictionary dictionary = new Dictionary();
        BufferedReader reader = new BufferedReader(new FileReader("dictionary.txt"));
        String line;
        while((line= reader.readLine())!=null){
            String[] lineSplit = line.split(",");
            System.out.println(lineSplit[0]);
            dictionary.insert(new Word(lineSplit[0], lineSplit[1]));
        }
        return dictionary;
    }

}
