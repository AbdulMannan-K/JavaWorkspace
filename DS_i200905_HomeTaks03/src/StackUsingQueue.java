public class StackUsingQueue<T> {

    private Queue<T> queueOne ;
    private Queue<T> queueTwo ;

    public StackUsingQueue(int size)
    {
        queueOne = new Queue<>(size);
        queueTwo = new Queue<>(size);
    }

    public void push(T value)
    {
        queueTwo.enqueue(value);
        while (!queueOne.isEmpty())
        {
            queueTwo.enqueue(queueOne.peek());
            queueOne.dequeue();
        }
        Queue<T> q = queueOne;
        queueOne = queueTwo;
        queueTwo = q;
    }

    public void pop()
    {
        if (queueOne.isEmpty())
            return;
        queueOne.dequeue();
    }

    public T top()
    {
        if (queueOne.isEmpty())
            return null;
        return queueOne.peek();
    }

    public Queue<T> getQueueOne() {
        return queueOne;
    }

    public Queue<T> getQueueTwo() {
        return queueTwo;
    }
}
