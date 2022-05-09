import java.io.*;
public class pathFIle {

        public static void main(String[] args) throws FileNotFoundException {
            File file = new File("C:/Users/abdul/Downloads/"); // any adress can be given
            String[] filenames = file.list();

            for (String files : filenames)
                System.out.print(files + "\n");

        }
    }
