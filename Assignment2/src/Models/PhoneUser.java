package Models;

import LinkedLists.SinglyList;
import Nodes.DoublyNode;

public class PhoneUser {

    private DoublyNode<Citizen> citizen;
    private SinglyList<Number> numbers = new SinglyList<>();;

    public PhoneUser(DoublyNode<Citizen> citizen){
        this.citizen = citizen;
    }

    public SinglyList<Number> getNumbers() {
        return numbers;
    }

    public DoublyNode<Citizen> getCitizen() {
        return citizen;
    }

    public void setCitizen(DoublyNode<Citizen> citizen) {
        this.citizen = citizen;
    }

    public void setNumbers(SinglyList<Number> numbers) {
        this.numbers = numbers;
    }
}
