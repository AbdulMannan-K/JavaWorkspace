import java.io.*;
import java.nio.file.Files;
public class readable {

        public static void main(String[] args)
        {
            try {

                File file = new File("C:/Users/abdul/Downloads/myfile.txt");


                if(file.exists())
                    System.out.println("Entered File exists." );
                else
                    System.out.println("Entered File not exists." );

                if(file.canRead())
                    System.out.println("Entered File readable.");
                else
                    System.out.println("Entered File not readable." );

                if(file.canWrite())
                    System.out.println("Entered File writable." );
                else
                    System.out.println("Entered File not writable." );



                System.out.print(Files.probeContentType(file.toPath()) + "\n");

                System.out.print("Entered File size is : "+ Files.size(file.toPath()) + "\n");

            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
