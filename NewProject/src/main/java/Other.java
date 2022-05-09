import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Other {


    public static void main(String[] args) {
        String s1= "Java Programming";

        char[] chars = s1.toCharArray();
        HashMap<Character,Integer> instances = new HashMap<>();
        for(int i=0 ; i < chars.length ; i++){
            if(instances.containsKey(chars[i])) {
                instances.replace(chars[i],instances.get(chars[i])+1);
            }
            instances.put(chars[i],1);
        }

    }

}
