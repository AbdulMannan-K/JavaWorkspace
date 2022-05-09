public class Main {

    public static void main(String[] args){
        Admin.setPassword();
        Bank bank = new Bank();
        bank.read();
        bank.showMenu();
    }

}