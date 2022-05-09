public class Node {

    private DictionaryWord data;
    private Node left;
    private Node right;

    private int height;

    public Node(DictionaryWord data){
        this.data=data;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public DictionaryWord getData() {
        return data;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setData(DictionaryWord data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
