import java.util.Objects;

public class PrimaryNumerBased extends BST<Integer>{

    public void check(Integer data){
        checkRotate(getRoot(),data);
    }
    public void checkRotate(Node<Integer> root,Integer data){
        if(Objects.equals(root.getLeft().getData(), data) ) {
            if(!isPrime(data)){
                if(data%2==0) root.setLeft(rotateAntiCLockwise(root.getLeft()));
                else root.setLeft(rotateClockwise(root.getLeft()));
            }
        }else if(root.getRight().getData().equals(data)){
            if(!isPrime(data)){
                if(data%2==0) root.setRight(rotateAntiCLockwise(root.getRight()));
                else root.setRight(rotateClockwise(root.getRight()));
            }
        }
        else if(data.compareTo(root.getData())>0)  checkRotate(root.getRight(),data);
        else if(data.compareTo(root.getData())<0)  checkRotate(root.getLeft(),data);
    }

    @Override
    protected Node<Integer> searchNode(Node<Integer> root, Integer data) {
        if(Objects.equals(root.getLeft().getData(), data) || root.getRight().getData().equals(data)) return root;
        else if(data.compareTo(root.getData())>0) return searchNode(root.getRight(),data);
        else if(data.compareTo(root.getData())<0) return searchNode(root.getLeft(),data);
        return root;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
