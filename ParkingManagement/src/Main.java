public class Main {
    public static void main(String[] args){
        ParkingGarage park = new ParkingGarage(); // 1st garage Area (default size ie 5)
        boolean check = park.ParkCar("S12",1);
        if(!check)
            System.out.println("Garage is Full!");
        System.out.println("the remaining places in garage are: "+park.getRemainingCapacity()); // only 1 location is occupied
        System.out.println("The reg no of car at 01 location is : "+ park.carPointer[0].getRegNo());
        System.out.println("The entry time of car at 01 location is : "+ park.carPointer[0].getEntryTime() );
        park.RemoveCar("S12",5); // that one location is also removed now whole garage is free
        System.out.println("your bill is : " + park.getAmountCollected());
        System.out.println("the remaining places in garage are: "+park.getRemainingCapacity());

        System.out.println();

        ParkingGarage park2 = new ParkingGarage(2); // 2nd garage area (now size of garage is 2)
        check = park2.ParkCar("J12",1);
        if(!check)
            System.out.println("Garage is Full!");
        System.out.println("the remaining places in garage are: "+park2.getRemainingCapacity()); // only 1 location is occupied
        System.out.println("The reg no of car at 01 location is : "+ park2.carPointer[0].getRegNo());
        System.out.println("The entry time of car at 01 location is : "+ park2.carPointer[0].getEntryTime() );
        park2.RemoveCar("J12",3); // that one location is also removed now whole garage is free
        System.out.println("your bill is : " + park2.getAmountCollected());
        System.out.println("the remaining places in garage are: "+park2.getRemainingCapacity());

    }
}
