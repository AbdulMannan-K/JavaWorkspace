public class Main {

    public static void main(String[] args) {
        String sentence = "fast cat is runnning";
        System.out.println(reverse(sentence));
        System.out.println(getELFish("elld",0));
    }

    public static int getGCD(int numberOne, int numberTwo){
        if(numberTwo !=0 )
            return getGCD(numberTwo,numberOne%numberTwo);
        else
            return  numberOne;
    }

    public static String reverse(String sentence){
        String[] line = sentence.split(" ", 2);
        if(line.length>1) {
            return reverse(line[1]) + " " + line[0];
        }
        return line[0];
    }

    public static boolean getELFish(String word , int elf  ){
        System.out.println(elf);
        if(word.length()==0) return false;
        if(word.charAt(0) == 'e' || word.charAt(0) == 'l' || word.charAt(0) == 'f'){
            elf++;
        }
        if(elf==3) return true;
        return getELFish(word.substring(1),elf);
    }

}
