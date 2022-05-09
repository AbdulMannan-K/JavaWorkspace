public class BST<T extends Comparable<T>> {

    private Node<T> root;

    public BST(){
        root = null;
    }

    public void insert(T value){
         root = insertNode(root,value);
    }

    public void displayInOrder(){
        displayIn(root);
    }

    public void displayPreOrder(){
        displayPre(root);
    }

    public void displayPostOrder(){
        displayPost(root);
    }

    public Node<T> insertNode(Node<T> root, T value){
        Node<T> newNode = new Node<T>(value);
        if(root==null) return newNode;
        else{
            if(root.getData().compareTo(value) > 0) root.setLeft(insertNode(root.getLeft(), value));
            else if(root.getData().compareTo(value) < 0) root.setRight(insertNode(root.getRight(),value));
        }
        return root;
    }

    public void displayIn(Node<T> root){
        if(root==null) return;
        else{
            displayIn(root.getLeft());
            System.out.println(root.getData());
            displayIn(root.getRight());
        }
    }

    public void displayPre(Node<T> root){
        if(root==null) return;
        else{
            System.out.println(root.getData());
            displayPre(root.getLeft());
            displayPre(root.getRight());
        }
    }

    public void displayPost(Node<T> root){
        if(root==null) return;
        else{
            displayPost(root.getLeft());
            displayPost(root.getRight());
            System.out.println(root.getData());
        }
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
