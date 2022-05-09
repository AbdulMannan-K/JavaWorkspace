public class StringCount {

    public void count(String string){
        int vowelcount=0,digitcount=0,upper=0,lower=0,word=0,special =0;
        String[] arr = string.split("\n");
        int line = arr.length;
        for(int i=0 ; i < arr.length ; i++){
            for(int  j=0 ; j < arr[i].length() ; j++) {
                char ch = arr[i].charAt(j);

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowelcount++;
                if (ch >= 'A' && ch <= 'Z')
                    upper++;
                if (ch >= 'a' && ch <= 'z')
                    lower++;
                if (ch >= '0' && ch <= '9')
                    digitcount++;
                if (ch=='\"' || ch == '.' || ch == ',' || ch == '?' || ch == '-' || ch == ')' || ch == '(' || ch == ' ')
                    special++;
                word++;
            }
        }
        System.out.println("The words in given string are : " + word + "\nVowels are : " + vowelcount + "\nDigits are : " + digitcount + "\nspecial are : " + special + "\nUpper letters are : "+ upper + "\nlower letters are : " + lower + "\n Lines are : " + line);

    }

}
