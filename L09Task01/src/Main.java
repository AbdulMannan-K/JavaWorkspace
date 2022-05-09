public class Main {
    public static void main(String[] args){

        Question question = new TF();

        System.out.println(question.getText());
        System.out.println(question.ask());

        question = new ShortAnswerQuestion();
        System.out.println(question.getText());
        System.out.println(question.ask());

        question = new MCQ();
        System.out.println(question.getText());
        System.out.println(question.ask());

    }

}
