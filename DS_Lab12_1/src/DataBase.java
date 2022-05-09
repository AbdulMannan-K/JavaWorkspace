import java.util.ArrayList;

public class DataBase extends BST<City> {

    @Override
    public void displayInOrder() {
        super.displayInOrder();
    }

    @Override
    public void displayIn(Node<City> root) {
        if(root==null) return;
        else{
            displayIn(root.getLeft());
            System.out.println(root.getData().getID());
            displayIn(root.getRight());
        }
    }

    @Override
    public void displayPre(Node<City> root) {
        if(root==null) return;
        else{
            System.out.println(root.getData().getID());
            displayPre(root.getLeft());
            displayPre(root.getRight());
        }
    }

    @Override
    public void displayPreOrder() {
        super.displayPreOrder();
    }

    @Override
    public void displayPost(Node<City> root) {
        if(root==null) return;
        else{
            displayPost(root.getLeft());
            displayPost(root.getRight());
            System.out.println(root.getData().getID());
        }
    }

    @Override
    public void displayPostOrder() {
        super.displayPostOrder();
    }

    public ArrayList<Node<City>> retrieveByCountry(String country){
        return getCountry(super.getRoot(),country,new ArrayList<Node<City>>());
    }
    public ArrayList<Node<City>> getCountry(Node<City> root,String country,ArrayList<Node<City>> result){
        if(root==null) return null;
        getCountry(root.getLeft(),country,result);
        if(root.getData().getCountry().equals(country)) result.add(root);
        getCountry(root.getRight(),country,result);
        return result;
    }

    public void deleteNode(int population){
        super.setRoot(traverse(super.getRoot(),population));
    }

    public Node<City> traverse(Node<City> root,int population){
        if(root==null) return null;
        root.setLeft(traverse(root.getLeft(),population));
        if(root.getData().getPopulation()==population)
            root = deleteNode(root);
        root.setRight(traverse(root.getRight(),population));
        return root;
    }

    public Node<City> deleteNode(Node<City> root){
        if(root.getRight()==null && root.getLeft()==null) return null;
        else if(root.getRight()!=null && root.getLeft()==null) return root.getRight();
        else if(root.getLeft()!=null && root.getRight()==null) return root.getLeft();
        else{
            Node<City> node =  getMinimum(root.getRight());
            node.setLeft(root.getLeft());
            root = root.getRight();
            return root;
        }
    }

    public int getHeight(Node<City> root){
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

    public boolean bb(){
        return isBalanced(super.getRoot());
    }
    public boolean isBalanced(Node<City> root){
        if(root==null) return true;
        int a = getHeight(root.getRight())-getHeight(root.getLeft());
        if(a==0||a==1||a==-1) return isBalanced(root.getLeft()) && isBalanced(root.getRight());
        else return false;
    }

    public Node<City> getMinimum(Node<City> root){
        if(root.getLeft()==null) return root;
        return getMinimum(root.getLeft());
    }



}
