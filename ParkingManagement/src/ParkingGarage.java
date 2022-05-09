public class ParkingGarage {

    private int capacity;
    private int noOfOccupied;
    private double amountCollected;
    private int CarNo;
    Car[] carPointer;

    ParkingGarage(int c){
        setAmountCollected(0);
        setCapacity(c);
        setNoOfOccupied(0);
        setCarNo(0);
        carPointer = new Car[c];
        for(int i=0 ; i< c ;i++)
            carPointer[i] = new Car();
    }

    ParkingGarage(){
        setAmountCollected(0);
        setCapacity(5);
        setNoOfOccupied(0);
        setCarNo(0);
        carPointer = new Car[5];
        for(int i=0 ; i< 5 ;i++)
            carPointer[i] = new Car();
    }

    public int getCarNo() {
        return CarNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getAmountCollected() {
        return amountCollected;
    }

    public int getNoOfOccupied() {
        return noOfOccupied;
    }

    public void setAmountCollected(double amountCollected) {
        this.amountCollected = amountCollected;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCarNo(int carNo) {
        CarNo = carNo;
    }

    public void setNoOfOccupied(int noOfOccupied) {
        if(noOfOccupied<getCapacity())
            this.noOfOccupied = noOfOccupied;
        else
            System.out.println("You are exceeding limit!");
    }

    public int getRemainingCapacity(){
        return getCapacity()-getNoOfOccupied();
    }

    public boolean isFull(){
        return getRemainingCapacity() == 0;
    }

    public boolean ParkCar(String regNo , double entryTime){
        if (isFull())
            return false;
        else {
            setNoOfOccupied(getNoOfOccupied()+1);
            int i=0;
            for(; i< getCapacity() ;i++){
                if(carPointer[i].getRegNo().equals("") && carPointer[i].getEntryTime()==0 && carPointer[i].getExitTime()==0)
                    break;
            }
            setCarNo(i);
            carPointer[getCarNo()].setRegNo(regNo);
            carPointer[getCarNo()].setEntryTime(entryTime);
            return true;
        }
    }

    public void RemoveCar(String regNo , double exitTime){
        int i=0;
        boolean isHere = true;
        for(; i < getCapacity() ;i++)
            if(regNo.equals(carPointer[i].getRegNo()))
                break;
            else
                isHere = false;

        if(!isHere){
            System.out.println("Car of this name is not present in garage! , exiting!");
            System.exit(0);
        }

        carPointer[i].setExitTime(exitTime);
        for(int j=0 ; j< carPointer[i].getExitTime()-carPointer[i].getEntryTime() ; j++)
            setAmountCollected(getAmountCollected()+20);

        setNoOfOccupied(getNoOfOccupied()-1);
        carPointer[i].setRegNo("");
        carPointer[i].setEntryTime(0);
        carPointer[i].setExitTime(0);
    }

}
