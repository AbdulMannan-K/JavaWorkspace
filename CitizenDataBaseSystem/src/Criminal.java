public class Criminal {

    private final Citizen citizen;
    private SingleLinkedList<Crime> crimes;

    Criminal(Citizen citizen) {
        this.citizen = citizen;
        crimes=new SingleLinkedList<>();
    }

    public SingleLinkedList<Crime> getCrimes() {
        return crimes;
    }

    public Citizen getCitizen() {
        return citizen;
    }
}
