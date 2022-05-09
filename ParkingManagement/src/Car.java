public class Car {

    private double entryTime;
    private double exitTime;
    private String regNo;

    public void setEntryTime(double entryTime){
        if(entryTime>24||entryTime<0)
            System.out.println("Please Enter time in 24 hour format(0-24)!");
        else
            this.entryTime=entryTime;
    }

    public void setExitTime(double exitTime){
        if(exitTime>24||exitTime<0)
            System.out.println("Please Enter time in 24 hour format(0-24)!");
        else if(exitTime<getEntryTime())
            System.out.println("Please Enter exit time greater than entry time!");
        else
            this.exitTime=exitTime;
    }

    public void setRegNo(String regNo){
        this.regNo=regNo;
    }

    public double getEntryTime(){
        return entryTime;
    }

    public double getExitTime() {
        return exitTime;
    }

    public String getRegNo(){
        return regNo;
    }

    Car(){
        setRegNo("");
        setExitTime(0);
        setEntryTime(0);
    }
}
