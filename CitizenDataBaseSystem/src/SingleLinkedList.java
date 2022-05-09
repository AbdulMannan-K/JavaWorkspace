public class SingleLinkedList<T> {
    private SingleNode<T> head;

    public void addNode(T data){
        if(data instanceof Number)
            if(getSize()==4){
                System.out.println("4 Numbers are already Registered. Can't register more!");
                return;
            }
        SingleNode<T> singleNode = new SingleNode<T>(data);
        if(head==null) {
            singleNode.setNext(null);
            head = singleNode;
            return;
        }
        SingleNode<T> last = getLast();
        last.setNext(singleNode);
        singleNode.setNext(null);
    }

    public SingleNode<T> getLast(){
        SingleNode<T> singleNode =head;
        while(singleNode.getNext()!=null)
            singleNode = singleNode.getNext();

        return singleNode;
    }

    public int getSize(){
        SingleNode<T> singleNode = head;int size=0;
        while(singleNode !=null){
            size++;
            singleNode = singleNode.getNext();
        }
        return size;
    }

    public void insertAfter(T newData,T p_data){
        SingleNode<T> singleNode = new SingleNode<>(newData);
        SingleNode<T> temp=head;
        while (temp!=null){
            if(p_data.equals(temp.getData()))
                break;
            temp=temp.getNext();
        }
        assert temp != null;
        singleNode.setNext(temp.getNext());
        temp.setNext(singleNode);
    }

    public void deleteFromStart(){
        head= head.getNext();
    }

    public void deleteFromEnd(){
        SingleNode<T> temp =head;
        while(temp.getNext().getNext()!=null)
            temp=temp.getNext();
        temp.setNext(null);
    }

    public void deleteAny(T data){
        SingleNode<T> singleNode = new SingleNode<>(data);
        SingleNode<T> temp = head;
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

    public SingleNode<T> getHead() {
        return head;
    }
}
