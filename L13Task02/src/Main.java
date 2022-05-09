public class Main {

    public static void main(String[] args) throws RangeException {
        int i=51;

        Main main = new Main();
        main.square(i);

    }

    public void square(int x) throws RangeException {
        if (x < 10 || x > 50) {
            throw new RangeException("Number Out of range");
        }else
            System.out.println("Square of number is : " + x*x);
    }

}
