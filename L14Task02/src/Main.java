public class Main {

    public static void main(String[] args) {
        Father father = new Father(13);
        Son son = new Son(25);
        Daughter daughter = new Daughter(24);
        father.Iam();
        son.Iam();
        daughter.Iam();

        System.out.println();

        Father[] fathers = new Father[10];
        for(int i=0 ; i< 10 ; i++)
            if(i%2==0)
                fathers[i] = new Son((int)(i+10+(Math.random()*30)));
            else
                fathers[i] = new Daughter((int)(i+10+(Math.random()*30)));

        for(int i=0 ; i < 10 ;i++)
            fathers[i].Iam();
    }

}
