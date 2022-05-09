public class BST<T extends Comparable<T>> {

    private Node<T> root;


    public void displayInOrder(){
        displayIn(root);
    }

    public void displayPreOrder(){
        displayPre(root);
    }

    public void displayPostOrder(){
        displayPost(root);
    }

    protected void displayIn(Node<T> root){
        if(root==null) return;
        else{
            displayIn(root.getLeft());
            System.out.println(root.getData());
            displayIn(root.getRight());
        }
    }

    protected void displayPre(Node<T> root){
        if(root==null) return;
        else{
            System.out.println(root.getData());
            displayPre(root.getLeft());
            displayPre(root.getRight());
        }
    }

    protected void displayPost(Node<T> root){
        if(root==null) return;
        else{
            displayPost(root.getLeft());
            displayPost(root.getRight());
            System.out.println(root.getData());
        }
    }

    public void insert(T data){
        root = insertNode(root,data);
    }

    protected Node<T> insertNode(Node<T> root, T data){
        if(root==null) return new Node<T>(data);
        else if(data.compareTo(root.getData())<0) root.setLeft(insertNode(root.getLeft(),data));
        else if(data.compareTo(root.getData())>0) root.setRight(insertNode(root.getRight(),data));
        if(getBalance(root)< -1 || getBalance(root)>1) {
            return balanceTree(root);
        }
        return root;
    }

    public void delete(T data){
        root = deleteNode(root,data);
    }

    protected Node<T> deleteNode(Node<T> root, T data){
        if(root.getData().equals(data)) return deleteElement(root);
        else if(root.getData().compareTo(data)>0) root.setLeft(deleteNode(root.getLeft(),data));
        else if(root.getData().compareTo(data)<0) root.setRight(deleteNode(root.getRight(),data));
        if(getBalance(root)< -1 || getBalance(root)>1) {
            return balanceTree(root);
        }
        return root;
    }

    protected Node<T> deleteElement(Node<T> root){
        if(root.getLeft()==null && root.getRight()==null) return null;
        else if(root.getLeft()==null && root.getRight()!=null) return root.getRight();
        else if(root.getLeft()!=null && root.getRight()==null) return root.getLeft();
        else{
            Node<T> temp = getMinimum(root.getRight());
            deleteNode(this.root,getMinimum(root.getRight()).getData());
            root.setData(temp.getData());
            return root;
        }
    }

    protected Node<T> getMinimum(Node<T> root){
        if(root.getLeft()==null) return root;
        return getMinimum(root.getLeft());
    }

    public int getBalance(Node<T> root){
        return getHeight(root.getRight())-getHeight(root.getLeft());
    }

    public Node<T> balanceTree(Node<T> root){
        if(getBalance(root)>0){
            if(getBalance(root.getRight())>0) {
                return rotateAntiCLockwise(root);
            }
            else {
                root.setRight(rotateClockwise(root.getRight()));
                return rotateAntiCLockwise(root);
            }
        }else{
            if(getBalance(root.getLeft())<0) {
                return rotateClockwise(root);
            }
            else {
                root.setLeft(rotateAntiCLockwise(root.getLeft()));
                return rotateClockwise(root);
            }
        }
    }

    public Node<T> rotateAntiCLockwise(Node<T> root){
        Node<T> Right = root.getRight();
        Node<T> leftTemp = root.getRight().getLeft();
        Right.setLeft(root);
        root.setRight(leftTemp);
        return Right;
    }

    public Node<T> rotateClockwise(Node<T> root){
        Node<T> Left = root.getLeft();
        Node<T> rightTemp = root.getLeft().getRight();
        Left.setRight(root);
        root.setLeft(rightTemp);
        return Left;
    }

    public int getHeight(Node<T> root){
        if (root == null)
            return -1;
        else
        {
            int left = getHeight(root.getLeft());
            int right = getHeight(root.getRight());

            if (left > right)
                return (left + 1);
            else
                return (right + 1);
        }
    }

    public void search(T data){
        Node<T> node = searchNode(root,data);
        System.out.println("Data : " + node.getData());
    }

    protected Node<T> searchNode(Node<T> root, T data){
        if(data.compareTo(root.getData())>0) return searchNode(root.getRight(),data);
        else if(data.compareTo(root.getData())<0) return searchNode(root.getLeft(),data);
        return root;
    }

    protected Node<T> getRoot() {
        return root;
    }

    protected void setRoot(Node<T> root) {
        this.root = root;
    }
}
