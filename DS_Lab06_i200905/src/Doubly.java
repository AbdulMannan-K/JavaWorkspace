import java.util.ArrayList;

public class Doubly<T extends Comparable<T>> {

    private Node<T> head=null;

    public Node<T> getLast(){
        Node<T> node=head;
        do {
            node = node.getNext();
        }while(node.getNext()!=head);
        return node;
    }

    public void printList(){
        Node<T> node = head;
        do{
            System.out.println(node.getData());
            node=node.getNext();
        }while(node!=head);
    }

    public void insertAtStart(T data){
        Node<T> node = new Node<>(data);
        if(head==null){
            head=node;
            node.setNext(head);
            node.setPrev(head);
            return;
        }
        Node<T> last = getLast();
        head.setPrev(node);
        last.setNext(node);
        node.setNext(head);
        node.setPrev(last);
        head=node;
    }

    public void insertAtEnd(T data){
        Node<T> node = new Node<T>(data);
        if(head==null) {
            head = node;
            node.setNext(head);
            node.setPrev(head);
            return;
        }
        Node<T> last = getLast();
        last.setNext(node);
        node.setPrev(last);
        node.setNext(head);
        head.setPrev(node);
    }

    public void insertAfter(T newData,T p_data){
        Node<T> newNode = new Node<>(newData);
        Node<T> temp=head;
        do{
            if(p_data.equals(temp.getData()))
                break;
            temp=temp.getNext();
        }while (temp!=head);
        newNode.setNext(temp.getNext());
        newNode.setPrev(temp);
        temp.getNext().setPrev(newNode);
        temp.setNext(newNode);
    }

    public void deleteFromStart(){
        Node<T> last = getLast();
        head= head.getNext();
        last.setNext(head);
        head.setPrev(last);
    }

    public void deleteFromEnd(){
        Node<T> temp =head;
        while(temp.getNext().getNext()!=head)
            temp=temp.getNext();
        temp.setNext(head);
        head.setPrev(temp);
    }

    public void deleteAny(T data){
        Node<T> temp = head;
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

    public int getSize(){
        Node<T> node = head;
        int i=0;
        do{
            node=node.getNext();
            i++;
        }while(node!=head);
        return i;
    }

    public void sort(){

        Node<T> firstNode = head;

        do{
            Node<T> secondNode = firstNode;
            do{
                if(firstNode.getData().compareTo(secondNode.getData())>0){
                    T temp = firstNode.getData();
                    firstNode.setData(secondNode.getData());
                    secondNode.setData(temp);
                }
                secondNode=secondNode.getNext();
            }while(secondNode!=head);
            firstNode=firstNode.getNext();
        }while(firstNode!=head);

    }

    public int findFrequency(T data){
        Node<T> node = head;
        int i=0;
        do{
            if(node.getData().equals(data))
                i++;
            node=node.getNext();
        }while (node!=head);
        return i;
    }

}
