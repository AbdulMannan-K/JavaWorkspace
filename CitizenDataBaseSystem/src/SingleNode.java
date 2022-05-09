public class SingleNode<T> {
    private T data;
    private SingleNode<T> next;

    public SingleNode(T data, SingleNode<T> next){
        this.data = data;
        this.next=next;
    }

    public SingleNode(T data){
        this.data = data;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }
}

// have to change SingleNode in singleLinkedList