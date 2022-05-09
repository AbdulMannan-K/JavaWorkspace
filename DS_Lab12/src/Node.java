public class Node<T extends Comparable<T>> {

    private Node<T> right;
    private Node<T> left;

    private T data;

    public Node(T data){
        this.data=data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
