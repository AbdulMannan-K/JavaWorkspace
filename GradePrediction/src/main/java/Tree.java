public class Tree <T>{

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
        this.root.setParent(null);
    }
}
