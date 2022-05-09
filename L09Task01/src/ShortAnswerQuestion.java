import java.util.Scanner;

public class ShortAnswerQuestion extends Question{

    @Override
    String ask() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your answer : ");
        String ans = scan.nextLine();

        if(ans.equals("National animal of Pakistan is Markhor"))
            return "\nYour answer is correct!\n";
        else
            return "\nYour answer is wrong, correct answer is \" National animal of Pakistan is Markhor \" \n";

    }

    ShortAnswerQuestion(){
        super.text = "What is national animal of Pakistan";
        super.setWeight(50);
    }
}
