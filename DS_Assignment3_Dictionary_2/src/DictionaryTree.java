import java.io.*;

import static java.lang.Math.max;

public class DictionaryTree {

    private Node root;


    public void insert(DictionaryWord data)
    {
        root = insert(data, root);
    }

    private Node insert(DictionaryWord data, Node root)
    {
        if (root == null)
            root = new Node(data);
        else if (data.compareTo(root.getData())<0)
        {
            root.setLeft(insert(data,root.getLeft()));

            if( height( root.getLeft() ) - height( root.getRight() ) == 2 )
                if( data.compareTo(root.getLeft().getData()) < 0) root = rotateWithLeftChild( root );
                else{
                    root.setLeft(rotateWithRightChild(root.getLeft()));
                    root = rotateWithLeftChild(root);
                }
        }
        else if( data.compareTo(root.getData())>0)
        {
            root.setRight(insert( data, root.getRight() ));
            if( height( root.getRight() ) - height( root.getLeft() ) == 2 )
                if( data.compareTo(root.getRight().getData())> 0) root = rotateWithRightChild( root );
                else{
                    root.setRight(rotateWithLeftChild(root.getRight()));
                    root = rotateWithRightChild(root);
                }
        }

        root.setHeight(max( height( root.getLeft() ), height( root.getRight() ) ) + 1);
        return root;
    }

    private int height(Node root )
    {
        return root == null ? -1 : root.getHeight();
    }

    private Node rotateWithLeftChild(Node root)
    {
        Node left = root.getLeft();
        root.setLeft(left.getRight());
        root.setRight(left);
        left.setHeight(max( height( left.getLeft() ), height( left.getRight() ) ) + 1);
        root.setHeight(max( height( root.getLeft() ),left.getHeight() ) + 1);
        return left;
    }

    private Node rotateWithRightChild(Node root)
    {
        Node right = root.getRight();
        root.setRight(right.getLeft());
        right.setLeft(root);
        root.setHeight(max( height( root.getLeft() ), height( root.getRight() ) ) + 1);
        right.setHeight(max( height( right.getRight() ), root.getHeight() ) + 1);
        return right;
    }

    public void Search(String word){
        DictionaryWord w = new DictionaryWord(word,"");
        Node node = Search(root,w);
        if(node==null) {
            System.out.println("Word not Found");
        }else {
            System.out.println("Word = " + node.getData().getWord() + " Meaning = " + node.getData().getMeaning());
        }
    }

    public Node Search(Node root, DictionaryWord word){
        if(root==null) {
            return null;
        }
        else if(word.compareTo(root.getData())>0) {
            return Search(root.getRight(), word);
        }
        else if(word.compareTo(root.getData())<0) {
            return Search(root.getLeft(), word);
        }
        return root;
    }

    public void InOrder(){
        displayInOrder(root);
    }

    public void PreOrder(){
        displayPreOrder(root);
    }

    public void PostOrder(){
        displayPostOrder(root);
    }

    protected void displayInOrder(Node root){
        if(root==null) ;
        else{
            displayInOrder(root.getLeft());
            System.out.println("Word : " + root.getData().getWord()+"  Meaning : "+root.getData().getMeaning());
            displayInOrder(root.getRight());
        }
    }

    protected void displayPreOrder(Node root){
        if(root==null) ;
        else{
            System.out.println("Word : " + root.getData().getWord()+"  Meaning : "+root.getData().getMeaning());
            displayPreOrder(root.getLeft());
            displayPreOrder(root.getRight());
        }
    }

    protected void displayPostOrder(Node root){
        if(root==null) ;
        else{
            displayPostOrder(root.getLeft());
            displayPostOrder(root.getRight());
            System.out.println("Word : " + root.getData().getWord()+"  Meaning : "+root.getData().getMeaning());
        }
    }

    public void WInOrder() throws IOException {
        FileWriter fileWriter = new FileWriter("InOrder.txt");
        WriteInOrder(fileWriter,root);
        fileWriter.close();
    }

    public void WPreOrder() throws IOException {
        FileWriter fileWriter = new FileWriter("PreOrder.txt");
        WritePreOrder(fileWriter,root);
        fileWriter.close();
    }

    public void WPostOrder() throws IOException {
        FileWriter fileWriter = new FileWriter("PostOrder.txt");
        WritePostOrder(fileWriter,root);
        fileWriter.close();
    }

    protected void WriteInOrder(FileWriter fileWriter,Node root) throws IOException {
        if(root==null) ;
        else{
            displayInOrder(root.getLeft());
            fileWriter.write("Word : " + root.getData().getWord()+"  Meaning : "+root.getData().getMeaning()+"\n");
            displayInOrder(root.getRight());
        }
    }

    protected void WritePreOrder(FileWriter fileWriter,Node root) throws IOException {
        if(root==null) ;
        else{
            fileWriter.write("Word : " + root.getData().getWord()+"  Meaning : "+root.getData().getMeaning()+"\n");
            displayPreOrder(root.getLeft());
            displayPreOrder(root.getRight());
        }
    }

    protected void WritePostOrder(FileWriter fileWriter,Node root) throws IOException {
        if(root==null) ;
        else{
            displayPostOrder(root.getLeft());
            displayPostOrder(root.getRight());
            fileWriter.write("Word : " + root.getData().getWord()+"  Meaning : "+root.getData().getMeaning()+"\n");
        }
    }

    public void RInOrder() throws IOException {
        Read("InOrder.txt");
    }

    public void RPreOrder() throws IOException {
        Read("PreOrder.txt");
    }

    public void RPostOrder() throws IOException {
        Read("PostOrder.txt");
    }

    public void Read(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = "";
        while((line=bufferedReader.readLine())!=null){
            String[] split = line.split("=");
            DictionaryWord word = new DictionaryWord(split[0],split[1]);
            insert(word);
        }
    }
}
