package LinkedLists;

import Nodes.DoublyNode;

public class CircularDoublyList<T> {

    private DoublyNode<T> head=null;

    public void addNode(DoublyNode<T> node){
        if(head==null) {
            head = node;
            node.setNext(head);
            node.setPrev(head);
            return;
        }
        DoublyNode<T> last = getLast();
        last.setNext(node);
        node.setPrev(last);
        node.setNext(head);
        head.setPrev(node);
    }

    public DoublyNode<T> getLast() {
        DoublyNode<T> doublyNode = head;
        while (doublyNode.getNext() != head)
            doublyNode = doublyNode.getNext();

        return doublyNode;
    }

    public DoublyNode<T> getHead() {
        return head;
    }
}
