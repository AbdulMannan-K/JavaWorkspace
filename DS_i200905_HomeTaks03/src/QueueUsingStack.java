public class QueueUsingStack<T> {

    private Stack<T> stackOne ;
    private Stack<T> stackTwo ;

    public QueueUsingStack(int size){
        stackOne = new Stack<>(size);
        stackTwo = new Stack<>(size);
    }

    public void enQueue(T value)
    {
        while (!stackOne.isEmpty())
        {
            stackTwo.push(stackOne.pop());
        }
        stackOne.push(value);
        while (!stackTwo.isEmpty())
        {
            stackOne.push(stackTwo.pop());
        }
    }

    public T deQueue()
    {
        if (stackOne.isEmpty())
        {
            System.out.println("Stack is Empty");
            System.exit(0);
        }
        T value = stackOne.peek();
        stackOne.pop();
        return value;
    }

    public Stack<T> getStackOne() {
        return stackOne;
    }

    public Stack<T> getStackTwo() {
        return stackTwo;
    }
}
