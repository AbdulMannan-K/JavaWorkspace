public class Queue<T> {

    private Object[] array;
    private int front;
    private int rear;
    public int size;

    public Queue(int size){
        this.size = size;
        this.array = new Object[size];
        front=-1;
        rear=-1;
    }

    public Queue(){
        this.array = new Object[0];
        front=rear=-1;
    }

    public void printQueue(){
        for(int i=front ; i <= rear ; i++)
            System.out.println(array[i]);
    }

    public void enqueue(T element){
        if(isEmpty()){
            array[++front] = element;rear++;
        }
        else if(isFull()){
            System.out.println("Already Full");
        }else
            array[++rear]=element;
    }

    public T dequeue(){
        Object obj=null;
        if(isEmpty())
            System.out.println("Already Empty!");
        else {
             obj = array[front];
            array[front] = null;
            front++;
        }
        return (T)obj;
    }

    public T peek(){
        return (T)array[front];
    }

    public boolean isEmpty(){
        return front == rear && front == -1;
    }

    public boolean isFull(){
        return rear == array.length-1 ;
    }

    public T getRearObject(){
        return (T) array[rear];
    }

    public void setFrontObject(T front){
        array[this.front] = front;
    }

    public void setRearObject(T rear){
        array[this.rear] = rear;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getSize() {
        return size;
    }
}
