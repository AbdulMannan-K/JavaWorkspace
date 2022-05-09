import java.util.Scanner;

public class TF extends Question{

    @Override
    String ask() {
        Scanner scan = new Scanner(System.in);
        String choice;
        do{
            System.out.print("Enter your answer in True or False : ");
            choice = scan.next();
        }while (!choice.equals("T")&&!choice.equals("F")&&!choice.equals("t")&&!choice.equals("f"));

        if(choice.equals("T")||choice.equals("t")){
            return "\nYour answer is right!\n";
        }else
            return "\nYour answer is wrong, correct answer is True\n";
    }

    TF(){
        super.text="Pakistan is a democratic Country?" ;
        super.setWeight(20);
    }
}
