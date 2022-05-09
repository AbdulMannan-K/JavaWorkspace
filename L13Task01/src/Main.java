public class Main {

    public static void main(String[] args){

        int size=-2;

        try{
            int[] arr =new int[size];
        }catch (NegativeArraySizeException e){
            e.printStackTrace();
        }

    }

}
