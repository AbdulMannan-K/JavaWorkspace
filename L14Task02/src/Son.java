public class Son extends Father{
    Son(int age){
        super(age);
    }

    @Override
    public void Iam() {
        System.out.println("I am Son And my age is : " + super.age);
    }
}
