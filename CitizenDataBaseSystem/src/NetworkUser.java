public class NetworkUser {

    private Citizen citizen;
    private SingleLinkedList<Number> numbers;

    public NetworkUser(Citizen citizen){
        this.citizen = citizen;
        numbers = new SingleLinkedList<>();
    }

    public SingleLinkedList<Number> getNumbers() {
        return numbers;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void setNumbers(SingleLinkedList<Number> numbers) {
        this.numbers = numbers;
    }
}
