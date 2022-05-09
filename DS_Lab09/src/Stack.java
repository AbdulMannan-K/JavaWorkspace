public class Stack<T> {

    private Node<T> top;

    public Stack(){
        top=null;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        node.setNext(top);
        top=node;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty!");
            return null;
        }
        T value=  top.getData();
        top=top.getNext();
        return value;
    }

    public T peek(){
        return top.getData();
    }

    public boolean isEmpty(){
        return top==null;
    }

    public Stack<T> inverseStack(){
        Node<T> temp = top;
        Stack<T> newStack = new Stack<>();
        while(temp!=null){
            newStack.push(temp.getData());
            temp=temp.getNext();
        }
        return newStack;
    }

    public Node<T> getTop() {
        return top;
    }

}
