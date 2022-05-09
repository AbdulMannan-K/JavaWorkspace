public class LinkedQueue <T>{

    private Node<T> front;
    private Node<T> rear;
    public int size=0;

    public LinkedQueue(){
        front=rear=null;
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        newNode.setNext(null);
        if(front==null){
            front=rear=newNode;
        }
        else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    public T dequeue(){
        T d = front.getData();
        front=front.getNext();
        return d;
    }

    public void printQueue(){
        Node<T> temp = front;
        while(front!=null){
            System.out.println(front.getData());
            front=front.getNext();
        }
    }


}
