package LinkedLists;

import Nodes.DoublyNode;

public class DoublyList<T>{

    private DoublyNode<T> head=null;

    public void addNode(DoublyNode<T> node) {
        if(head==null) {
            head = node;
            node.setNext(null);
            node.setPrev(null);
            return;
        }
        DoublyNode<T> last = getLast();
        last.setNext(node);
        node.setPrev(last);
        node.setNext(null);
    }

    public DoublyNode<T> getLast(){
        DoublyNode<T> doublyNode =head;
        while(doublyNode.getNext()!=null)
            doublyNode = doublyNode.getNext();

        return doublyNode;
    }

    public DoublyNode<T> getHead() {
        return head;
    }
}
