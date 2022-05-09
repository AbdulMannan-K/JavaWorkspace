import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Node<Integer>  head = new Node<>(5);
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.addNode(5);
        list.addNode(10);
        list.addNode(24);
        list.addNode(44);
        list.addNode(24);
        list.insertAtStart(30);
        list.insertAtEnd(25);

        list.printList();


        Node temp = list.getHead().getNext().getNext().getNext();
        System.out.println("\n"+temp.getData()+"\n");

        list.insertAfter(99,24);

        list.printList();

        list.deleteFromStart();

        System.out.println();

        list.printList();

        list.deleteFromEnd();

        System.out.println();

        list.printList();

        list.deleteAny(24);

        System.out.println();

        list.printList();

        list.deleteMax();

        System.out.println();

        list.printList();

        list.deleteMin();

        System.out.println();

        list.printList();

        list.reverse();

        System.out.println();

        list.printList();

        list.addNode(23);
        list.addNode(24);
        list.addNode(25);
        list.addNode(26);
        reverseList(list);
    }

    public static <T> void reverseList(LinkedList<T> list){
        System.out.println("-----------------------------------------------------------");
        list.printList();
        Node previous = null;
        Node current = list.getHead();
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        list.setHead(previous);
        System.out.println("-----------------------------------------------------------");
        list.printList();
    }

}
