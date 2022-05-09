public class LinkedList<T>{

    private Node<T> head;


    public void addNode(T data){
        Node<T> node = new Node<T>(data);
        if(head==null) {
            node.setNext(null);
            head = node;
            return;
        }
        Node<T> last = getLast();
        last.setNext(node);
        node.setNext(null);
    }

    public Node<T> getLast(){
        Node<T> node=head;
        while(node.getNext()!=null)
            node=node.getNext();

        return node;
    }

    public void printList(){
        Node<T> node = head;
        do{
            System.out.println(node.getData());
            node=node.getNext();
        }while(node!=null);
    }

    public void insertAtStart(T data){
        Node<T> node = new Node<>(data);
        if(head==null){
            head=node;
            node.setNext(null);
            return;
        }
        node.setNext(head);
        head=node;
    }

    public void insertAtEnd(T data){
        Node<T> node = new Node<>(data);
        Node<T> last = getLast();
        last.setNext(node);
        node.setNext(null);
    }

    public void insertAfter(T newData,T p_data){
        Node<T> newNode = new Node<>(newData);
        Node<T> temp=head;
        while (temp!=null){
            if(p_data.equals(temp.getData()))
                break;
            temp=temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
    }

    public void deleteFromStart(){
        head= head.getNext();
    }

    public void deleteFromEnd(){
        Node<T> temp =head;
        while(temp.getNext().getNext()!=null)
            temp=temp.getNext();
        temp.setNext(null);
    }

    public void deleteAny(T data){
        Node<T> node = new Node<T>(data);
        Node<T> temp = head;
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

    public int getSize(){
        Node<T> node = head;int i=0;
        do{
            node=node.getNext();
            i++;
        }while(node!=null);
        return i;
    }

    public void deleteMax(){
        int max=findMax();

        Node<T> temp = head;
        while(temp.getNext()!=null){
            if(temp.equals(head) && temp.getData().equals(max)) deleteFromStart();
            if(temp.getNext().getData().equals(max)){
                if(temp.getNext().getNext()==null)
                    temp.setNext(null);
                else
                    temp.setNext(temp.getNext().getNext());
            }
            temp=temp.getNext();
            if(temp==null) break;
        }
    }

    public int findMax(){
        Node<T> temp=head;
        int max=0;
        while(temp!=null){
            if((Integer)temp.getData()>max)
                max=(Integer)temp.getData();
            temp=temp.getNext();
        }
        return max;
    }

    public void deleteMin(){
        int min=findMin();

        Node<T> temp = head;
        while(temp.getNext()!=null){
            if(temp.equals(head) && temp.getData().equals(min)) deleteFromStart();
            if(temp.getNext().getData().equals(min)){
                if(temp.getNext().getNext()==null)
                    temp.setNext(null);
                else
                    temp.setNext(temp.getNext().getNext());
            }
            temp=temp.getNext();
            if(temp==null) break;
        }
    }

    public int findMin(){
        Node<T> temp=head;
        int min=1000000000;
        while(temp!=null){
            if((Integer)temp.getData()<min)
                min=(Integer)temp.getData();
            temp=temp.getNext();
        }
        return min;
    }

    public void reverse(){
        Node<T> first=null;
        Node<T> second= null;
        Node<T> temp=head;
        head=getLast();
        while (temp!= null) {
            second = temp.getNext();
            temp.setNext(first);
            first = temp;
            temp = second;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
