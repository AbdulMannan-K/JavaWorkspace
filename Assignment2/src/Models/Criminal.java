package Models;

import LinkedLists.SinglyList;
import Nodes.DoublyNode;

public class Criminal {

    private DoublyNode<Citizen> citizen;
    private SinglyList<Crime> crimes;

    public Criminal(DoublyNode<Citizen> citizen) {
        this.citizen = citizen;
        crimes=new SinglyList<>();
    }

    public SinglyList<Crime> getCrimes() {
        return crimes;
    }

    public DoublyNode<Citizen> getCitizen() {
        return citizen;
    }
}
