public class Daughter extends Father{
    Daughter(int age){
        super(age);
    }

    @Override
    public void Iam() {
        System.out.println("I am Daughter And my age is : " + super.age);
    }
}
