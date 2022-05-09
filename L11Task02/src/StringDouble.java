public class StringDouble {


    void checkdouble(String string){
        int count=0;
        for(int i=0 ; i< string.length() ; i++){
            count =0;
            for(int j=0 ; j < i ; j++){
                if(string[i]==string[j])
                    count++;
            }
        }
    }
}
