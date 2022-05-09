public class CircularLinkedList<T> {

    private DoubleNode<T> head=null;

    public DoubleNode<T> getLast(){
        DoubleNode<T> doubleNode =head;
        while(doubleNode.getNext()!=head)
            doubleNode = doubleNode.getNext();

        return doubleNode;
    }

    public void insertAtEnd(T data){
        DoubleNode<T> doubleNode = new DoubleNode<T>(data);
        if(head==null) {
            head = doubleNode;
            doubleNode.setNext(head);
            doubleNode.setPrev(head);
            return;
        }
        DoubleNode<T> last = getLast();
        last.setNext(doubleNode);
        doubleNode.setPrev(last);
        doubleNode.setNext(head);
        head.setPrev(doubleNode);
    }

    public void insertAfter(T newData,T p_data){
        DoubleNode<T> newDoubleNode = new DoubleNode<>(newData);
        DoubleNode<T> temp=head;
        do{
            if(p_data.equals(temp.getData()))
                break;
            temp=temp.getNext();
        }while (temp!=head);
        newDoubleNode.setNext(temp.getNext());
        newDoubleNode.setPrev(temp);
        temp.getNext().setPrev(newDoubleNode);
        temp.setNext(newDoubleNode);
    }

    public void deleteFromStart(){
        DoubleNode<T> last = getLast();
        head= head.getNext();
        last.setNext(head);
        head.setPrev(last);
    }
    public void deleteAny(T data){
        DoubleNode<T> temp = head;
        do{
            if(temp.equals(head) && temp.getData().equals(data)){
                deleteFromStart();
                break;
            }
            else if(temp.getData().equals(data)) {
                temp.getNext().setPrev(temp.getPrev());
                temp.getPrev().setNext(temp.getNext());
                break;
            }
            temp=temp.getNext();
        }while (temp != head);
    }

    public DoubleNode<T> getHead() {
        return head;
    }
}
