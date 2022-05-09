import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;

public class MCQ extends Question{

    @Override
    String ask() {
        Scanner scan = new Scanner(System.in);
        String choice;
        System.out.println("A- ozone depletion         B- air pollution         C- water pollution           D- corona virus");
        do {
            System.out.print("Enter right option : ");
            choice = scan.next();
        }while (!choice.equals("A")&&!choice.equals("B")&&!choice.equals("C")&&!choice.equals("D"));

        if(choice.equals("A"))
            return "\nAnswer is correct";
        else
            return "\nAnswer is incorrect, right option was A\n";
    }

    MCQ(){
        super.text = "Which of the following is cause of CFC's :";
        super.setWeight(30);
    }
}
