
import java.io.*;
//import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {
        Main write = new Main();

        FileWriter file1=  new FileWriter("name.txt");

        FileWriter file2= new FileWriter("RollNumbers.txt");

        write.NamenRoll(file1,file2);

        file1.close();
        file2.close();

    }

    public void NamenRoll(FileWriter file1 , FileWriter file2) throws IOException {
        FileReader file= new FileReader("Data.csv");
        BufferedReader bufferedReader = new BufferedReader(file);
        String line=bufferedReader.readLine();
        while(line != null) {
            String[] S = line.split(",");
            file1.write(S[0]+"\n");
            file2.write(S[1] + "\n");
            line=bufferedReader.readLine();
        }

        //        Scanner scan = new Scanner(file);

//        while (scan.hasNext()){ // if you have space between data then this will work
//            file1.write(scan.next());
//            file2.write(scan.next());
//        }
    }
}