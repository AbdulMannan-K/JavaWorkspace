public class Main {

    final static char openSquareBracket = '[';
    final static char closedSquareBracket = ']';
    final static char openCircleBracket = '(';
    final static char closedCircleBracket = ')';
    final static char openParenthesis = '{';
    final static char closedParenthesis = '}';

    public static void main(String[] args) {
        System.out.println(checkBalanced("{ 3 + ( 5 * 4 ) / (2 * 3)] + [ (2 * 2 + (9 * 1) ] }"));
        System.out.println(getBinary(5));
        System.out.println(postFix("((3+4) *(5/6 - 7))"));
        System.out.println(solvePostFix(postFix("((3+4) *((5/6) - 7))")));
        System.out.println(preFix("((3+4) *(5/6 - 7))"));
        System.out.println(solvePreFix(preFix("((3+4) *((5/6) - 7))")));
    }

    public static boolean checkBalanced(String expression){
        Stack<Character> stack = new Stack<Character>();

        char[] expressionChar = expression.toCharArray();
        for (char c : expressionChar) {
            if(c==openParenthesis || c==openCircleBracket || c==openSquareBracket) stack.push(c);
            switch(c){
                case closedParenthesis -> {
                    if(stack.peek()==openParenthesis) stack.pop();
                    else return false;
                }
                case closedCircleBracket -> {
                    if(stack.peek()==openCircleBracket) stack.pop();
                    else return false;
                }
                case closedSquareBracket -> {
                    if(stack.peek()==openSquareBracket) stack.pop();
                    else return false;
                }
            }
        }
        return true;
    }

    public static int get_precedence(char operator) {
        switch(operator) {
            case '+','-' -> {
                return 1;
            }
            case '*','/'-> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
        }
        return -1;
    }

    public static int solvePostFix(String expression){
        char[] charExpression = expression.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for(char c : charExpression){
            if(c=='1' || c=='2' ||c=='3' ||c=='4' ||c=='5' ||c=='6' ||c=='7' ||c=='8' ||c=='9') stack.push(Integer.parseInt(String.valueOf(c)));
            else if(c==' ') {
            }
            else{
                int integer2 = stack.pop();
                int integer1 = stack.pop();
                switch(c){
                    case '+' ->  stack.push(integer1+integer2);
                    case '-' -> stack.push(integer1-integer2);
                    case '*' -> stack.push(integer1*integer2);
                    case '/' -> stack.push(integer1/integer2);
                    case '^' -> stack.push((int)Math.pow(integer1,integer2));
                }
            }
        }
        return stack.pop();
    }

    public static int solvePreFix(String expression){
        char[] charExpression=reverseCharacterArray(expression);
        Stack<Integer> stack = new Stack<>();
        for(char c : charExpression){
            if(c=='1' || c=='2' ||c=='3' ||c=='4' ||c=='5' ||c=='6' ||c=='7' ||c=='8' ||c=='9') stack.push(Integer.parseInt(String.valueOf(c)));
            else if(c==' ') {
            }
            else{
                int integer1 = stack.pop();
                int integer2 = stack.pop();
                switch(c){
                    case '+' ->  stack.push(integer1+integer2);
                    case '-' -> stack.push(integer1-integer2);
                    case '*' -> stack.push(integer1*integer2);
                    case '/' -> stack.push(integer1/integer2);
                    case '^' -> stack.push((int)Math.pow(integer1,integer2));
                }
            }
        }
        return stack.pop();
    }

    public static String preFix(String expression) {
        char[] expressionChar = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

        String reverseExpression = String.valueOf(reverseCharacterArray(expression));
        System.out.println("Reverse : " + reverseExpression);

        expression = postFix(reverseExpression);
        reverseExpression = String.valueOf(reverseCharacterArray(expression));

        return reverseExpression;
    }

    public static char[] reverseCharacterArray(String string){
        char[] reverse = new char[string.length()];
        for(int i = string.length()-1 , j=0 ; i >= 0 ; i--,j++){
            if(string.charAt(i) ==closedCircleBracket)
                reverse[j] = openCircleBracket;
            else if(string.charAt(i) == openCircleBracket)
                reverse[j] = closedCircleBracket;
            else
                reverse[j]=string.charAt(i);
        }
        return reverse;
    }

    public static String postFix(String expression){
        String postFixExpression = "";
        char[] expressionChar = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : expressionChar){
            switch (c){
                case '1','2','3','4','5','6','7','8','9',' ' -> postFixExpression+=c;
                case openCircleBracket -> stack.push(c);
                case closedCircleBracket -> {
                    while(stack.peek()!=openCircleBracket){
                        postFixExpression+=stack.pop();
                    }
                    stack.pop();
                }
                default -> {
                    if(get_precedence(c)==-1){
                        return "Expression has some problem!";
                    }
                    if(stack.peek()==null) {
                        stack.push(c);
                    }
                    else {
                        while (get_precedence(c) < get_precedence(stack.peek()) )
                            postFixExpression+=stack.pop();
                    }
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()) postFixExpression += stack.pop();

        return postFixExpression;
    }

    public static String getBinary(int decimal){
        Stack<Integer> binary = new Stack<>();
        while(decimal > 0){
            binary.push(decimal%2);
            decimal /= 2;
        }
        String binaryString = "" ;
        while(!binary.isEmpty())
            binaryString+=binary.pop().toString();
        return binaryString;
    }

}
