import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String w ;

    public static void main(String[] args) {
        sum(100);
        int[] array = {1,2,3,4,5};
        makeTriangle(array,array,0,0);
        String word = "ABC";
        w=word;
        ArrayList<String> a = new ArrayList<String>();
        combinationOfAlphabets(word,0,1,word.length() , a);
    }

    public static void sum(int i){
        if(i==1000) return;
        else{
            if(i%10+(int)(i/100)==(int)((i%100)/10))
                System.out.println(i+ " ");
            sum(i+1);
        }
    }

    public static void combinationOfAlphabets(String word, int index, int secondIndex, int size, ArrayList<String> list){
        if(list.size()==size*2) return;
        if(index==size) index=0;
        if(secondIndex==size) secondIndex=0;
        System.out.println(word);
        char[] c = word.toCharArray();

        char temp = c[index];
        c[index] = c[secondIndex];
        c[secondIndex] = temp;

        String as = new String(c);

        if(!list.contains(as)) {
            word = as;
            list.add(word);
        }
        combinationOfAlphabets(word,index+1 , secondIndex+1 ,size,list);
    }

    public static void makeTriangle(int[] array,int[] secondArray,int index, int secondIndex){
        if(array.length==1) return;
        if(secondArray[secondArray.length-1]!=0 || array==secondArray) {
            array=secondArray;
            secondArray = new int[array.length-1];
            makeTriangle(array,secondArray,0,0);
            System.out.println(Arrays.toString(array));
        }else{
            secondArray[secondIndex] = array[index]+array[index+1];
            makeTriangle(array,secondArray,index+1,secondIndex+1);
        }

    }

}
