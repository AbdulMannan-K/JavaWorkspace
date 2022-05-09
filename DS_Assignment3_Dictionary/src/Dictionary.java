import java.io.FileWriter;
import java.io.IOException;

public class Dictionary extends BST<Word>{
    int i=0;
    @Override
    protected void displayIn(Node<Word> root) {
        if(root==null) return;
        else{
            displayIn(root.getLeft());
            System.out.println(root.getData().getWord()+"   "+root.getData().getMeaning());
            displayIn(root.getRight());
        }
        i++;
    }

    @Override
    protected void displayPost(Node<Word> root) {
        if(root==null) return;
        else{
            displayPost(root.getLeft());
            displayPost(root.getRight());
            System.out.println(root.getData().getWord()+"   "+root.getData().getMeaning());
        }
    }

    @Override
    protected void displayPre(Node<Word> root) {
        if(root==null) return;
        else{
            System.out.println(root.getData().getWord()+"   "+root.getData().getMeaning());
            displayPost(root.getLeft());
            displayPost(root.getRight());
        }
    }

    public void delete(String data){
        setRoot(deleteNode(getRoot(),data));
    }

    protected Node<Word> deleteNode(Node<Word> root, String data){
        if(root.getData().getWord().equals(data)) return deleteElement(root);
        else if(root.getData().getWord().compareTo(data)>0) root.setLeft(deleteNode(root.getLeft(),data));
        else if(root.getData().getWord().compareTo(data)<0) root.setRight(deleteNode(root.getRight(),data));
        if(getBalance(root)< -1 || getBalance(root)>1) {
            return balanceTree(root);
        }
        return root;
    }

    protected Node<Word> deleteElement(Node<Word> root){
        if(root.getLeft()==null && root.getRight()==null) return null;
        else if(root.getLeft()==null && root.getRight()!=null) return root.getRight();
        else if(root.getLeft()!=null && root.getRight()==null) return root.getLeft();
        else{
            Node<Word> temp = getMinimum(root.getRight());
            deleteNode(getRoot(),getMinimum(root.getRight()).getData());
            root.setData(temp.getData());
            return root;
        }
    }

    public void search(String data) {
        Node<Word> node = searchNode(super.getRoot(), data);
        if(node==null) System.out.println("Word not Found!");
        else System.out.println("Word : " + node.getData().getWord() + "\nMeaning : " + node.getData().getMeaning());
    }

    protected Node<Word> searchNode(Node<Word> root, String data){
        if(root==null) return null;
        else if(root.getData().getWord().equals(data)) return root;
        else if(data.compareTo(root.getData().getWord())>0) return searchNode(root.getRight(),data);
        else if(data.compareTo(root.getData().getWord())<0) return searchNode(root.getLeft(),data);
        return root;
    }

    public void writeFile(int option) throws IOException {
        FileWriter fw = new FileWriter("dictionary.txt");
        switch(option){
            case 1 -> writeInOrder(getRoot(),fw);
            case 2 -> writePreOrder(getRoot(),fw);
            case 3 -> writePostOrder(getRoot(),fw);
        }
        fw.close();
    }

    private void writeInOrder(Node<Word> root, FileWriter fw) throws IOException {
        if(root==null) return;
        else{
            writeInOrder(root.getLeft(),fw);
            fw.write(root.getData().getWord()+","+root.getData().getMeaning()+"\n");
            writeInOrder(root.getRight(),fw);
        }
    }
    private void writePreOrder(Node<Word> root, FileWriter fw) throws IOException {
        if(root==null) return;
        else{
            fw.write(root.getData().getWord()+","+root.getData().getMeaning()+"\n");
            writePreOrder(root.getLeft(),fw);
            writePreOrder(root.getRight(),fw);
        }
    }
    private void writePostOrder(Node<Word> root, FileWriter fw) throws IOException {
        if(root==null) return;
        else{
            writePostOrder(root.getLeft(),fw);
            writePostOrder(root.getRight(),fw);
            fw.write(root.getData().getWord()+","+root.getData().getMeaning()+"\n");
        }
    }

}