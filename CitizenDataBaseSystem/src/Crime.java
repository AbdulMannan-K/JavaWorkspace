public class Crime {

    private String details;
    private String charges;
    private String punishment;
    private int fine;

    Crime(String details, String charges, String punishment, int fine){
        this.details = details;
        this.charges = charges;
        this.punishment=punishment;
        this.fine=fine;
    }

    public String getPunishment() {
        return punishment;
    }

    public String getCharges() {
        return charges;
    }

    public int getFine() {
        return fine;
    }

    public String getDetails() {
        return details;
    }
}
