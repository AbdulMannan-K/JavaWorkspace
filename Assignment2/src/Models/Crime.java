package Models;

public class Crime {

    private String details;
    private String punishment;
    private int fine;

    public Crime(String details, String punishment, int fine){
        this.details = details;
        this.punishment=punishment;
        this.fine=fine;
    }

    public String getPunishment() {
        return punishment;
    }

    public int getFine() {
        return fine;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }
}
