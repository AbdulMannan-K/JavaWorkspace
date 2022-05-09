public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        System.out.println(stack.pop());

        printStack(stack);

        System.out.println(isPalindrome("revihjver"));

    }

    public static boolean isPalindrome(String word){

        Stack<Character> stack = new Stack<>();

        for(int i= 0; i < word.length() ; i++){
            stack.push(word.charAt(i));
        }

        Stack<Character> reverseStack = stack.copyStack();

        while (!stack.isEmpty()) {
            if (stack.peek() != reverseStack.peek())
                return false;

            stack.pop();
            reverseStack.pop();
        }

        return true;
    }

    public static <T> void printStack(Stack<T> stack){
        Node<T> temp = stack.copyStack().getTop();
        while(temp!=null){
            System.out.println(temp.getData());
            temp=temp.getNext();
        }
    }

}
