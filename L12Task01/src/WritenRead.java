import java.io.*;
import java.util.Scanner;

public class WritenRead {

    public static void main(String[] args) throws IOException {
        WritenRead writenRead = new WritenRead();

        FileOutputStream file = new FileOutputStream("file1.txt");
        DataOutputStream write = new DataOutputStream(file);
        FileInputStream fileIn = new FileInputStream("file1.txt");
        DataInputStream input = new DataInputStream(fileIn);

        writenRead.WriteData(write);

        System.out.println("Lines in program are : " + writenRead.CountLines(input));

        fileIn.close();
        fileIn = new FileInputStream("file1.txt");
        input = new DataInputStream(fileIn);

        writenRead.print(input);

        writenRead.copy("file1.txt","file2.txt");

        writenRead.Delete("file3.txt");

    }

    public void WriteData(DataOutputStream data)throws IOException{
        data.writeBytes("Name is -----");
        data.write(13);
        data.write(10);
        data.writeBytes("class is -----");
        data.write(13);
        data.write(10);
        data.writeBytes("Roll Number is -----");
        data.write(13);
        data.write(10);
        data.writeBytes("Section is -----");
    }

    public int CountLines(DataInputStream data)throws IOException{
        int lines=0;
        while (data.readLine() != null){
            lines++;
        }
        return lines;
    }

    public void print(DataInputStream data)throws IOException{
        int Totalwords = data.available();
//        System.out.print(Totalwords);
        byte[] wordsArray = new byte[Totalwords];
        data.read(wordsArray);
        for(byte word : wordsArray){
            char word1 = (char)word;
            System.out.print(word1);
        }
        System.out.println();
    }

    public void copy(String file1 , String file2)throws IOException{
        FileOutputStream data1 = new FileOutputStream(file2);
        DataOutputStream write = new DataOutputStream(data1);
        FileInputStream data = new FileInputStream(file1);
        DataInputStream read = new DataInputStream(data);


        int Totalwords = read.available();
        byte[] wordsArray = new byte[Totalwords];
        read.read(wordsArray);
        for(byte word : wordsArray){
            char word1 = (char)word;
            write.write(word1);
        }
    }

    public void Delete(String file){
        File file1 = new File(file);
        if(file1.delete())
            System.out.println(file1.getName() + " file deleted.");

        else
            System.out.println("file not found");

    }

}
