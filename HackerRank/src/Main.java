import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>> ();
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        for(int i=0 ; i < 6 ; i++){
            Random r = new Random();
            list.get(i).add(r.nextInt(20));
            list.get(i).add(r.nextInt(20));
            list.get(i).add(r.nextInt(20));
            list.get(i).add(r.nextInt(20));
            list.get(i).add(r.nextInt(20));
            list.get(i).add(r.nextInt(20));
        }
        System.out.println(Arrays.toString(list.toArray()));
        getHourGlassesSum(list);
    }

    public static int getHourGlassesSum(ArrayList<ArrayList<Integer>> list){
        int largestSum=0;
        for(int i=0 ; i < list.size() ; i++){
            for(int j=0 ; j < list.get(i).size() ; j++){
                if(getSum(list,i,j)>largestSum) largestSum=getSum(list,i,j);
            }
        }
        return largestSum;
    }

    public static int getSum(ArrayList<ArrayList<Integer>> list,int x,int y){
        if(y==0||x>list.size()-3||y>list.get(x).size()-2) return -1;
        return list.get(x).get(y) + list.get(x).get(y+1) + list.get(x).get(y-1) + list.get(x+1).get(y) + list.get(x+2).get(y) + list.get(x+2).get(y+1) + list.get(x+2).get(y-1);
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<Integer> list = new ArrayList<Integer>();
        queries.add
        int[][] array = new int[n][];
        int lastAnswer =0;
        for(int i=1 ; i < queries.size() ; i++){
            if(queries.get(i).get(0)==1){
                array[0][(queries.get(i).get(1)^lastAnswer)%n] = queries.get(i).get(2);
            }else if(queries.get(i).get(0)==2){
                lastAnswer = array[((queries.get(i).get(1))^lastAnswer)%n][queries.get(i).get(2)%array[queries.get(i).get(1)^lastAnswer].length];
                list.add(lastAnswer);
            }
        }
        return list;

    }

}
