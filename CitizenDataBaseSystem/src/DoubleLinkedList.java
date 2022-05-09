public class DoubleLinkedList <T>{

    private DoubleNode<T> head=null;

    public DoubleNode<T> getLast(){
        DoubleNode<T> doubleNode =head;
        while(doubleNode.getNext()!=null)
            doubleNode = doubleNode.getNext();

        return doubleNode;
    }

    public void insertAtEnd(T data){
        DoubleNode<T> doubleNode = new DoubleNode<T>(data);
        if(head==null) {
            head = doubleNode;
            doubleNode.setNext(null);
            doubleNode.setPrev(null);
            return;
        }
        DoubleNode<T> last = getLast();
        last.setNext(doubleNode);
        doubleNode.setPrev(last);
        doubleNode.setNext(null);
    }

    public DoubleNode<T> getHead() {
        return head;
    }
}
