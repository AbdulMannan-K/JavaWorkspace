public class    Main {

    public static void main(String[] args) {
        Doubly<Integer> list = new Doubly<>();
        list.insertAtEnd(222);
        list.insertAtEnd(10);
        list.insertAtEnd(10);
        list.insertAtEnd(10);
        list.insertAtEnd(10);
        list.insertAtEnd(23);
        list.insertAtEnd(12);
        list.insertAtEnd(9);

        list.insertAtStart(999);

        list.deleteFromStart();

        list.deleteFromEnd();

        list.deleteAny(23);
        list.insertAfter(69,10);
        list.insertAtEnd(69);

        list.printList();

        System.out.println();
        list.sort();
        list.printList();

//        list.removeRepeating();
        System.out.println();
        list.printList();

    }

}
