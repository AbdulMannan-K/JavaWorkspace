package LinkedLists;

import DataBases.CBID;
import Nodes.DoublyNode;
import Nodes.SinglyNode;

public class SinglyList<T> {
    private SinglyNode<T> head;

    public void addNode(T data){
        SinglyNode<T> singlyNode = new SinglyNode<T>(data);
        if(head==null) {
            singlyNode.setNext(null);
            head = singlyNode;
            return;
        }
        SinglyNode<T> last = getLast();
        last.setNext(singlyNode);
        singlyNode.setNext(null);
    }

    public SinglyNode<T> getLast(){
        SinglyNode<T> singlyNode =head;
        while(singlyNode.getNext()!=null)
            singlyNode = singlyNode.getNext();

        return singlyNode;
    }

    public void deleteFromStart(){
        head= head.getNext();
    }

    public void deleteAny(T data){
        SinglyNode<T> singlyNode = new SinglyNode<>(data);
        SinglyNode<T> temp = head;
        while(temp.getNext()!=null){
            if(temp.equals(head) && temp.getData().equals(data)) deleteFromStart();
            if(temp.getNext().getData().equals(data)){
                if(temp.getNext().getNext()==null)
                    temp.setNext(null);
                else
                    temp.setNext(temp.getNext().getNext());
            }
            temp=temp.getNext();
            if(temp==null) break;
        }
    }

    public int size(){
        SinglyNode<T> singlyNode = head;
        int i=0;
        while(singlyNode!=null){
            i++;
            singlyNode=singlyNode.getNext();
        }
        return i;
    }

    public SinglyNode<T> getHead() {
        return head;
    }
}
