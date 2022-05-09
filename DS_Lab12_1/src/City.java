public class City implements Comparable<City> {

    private int ID;
    private String Country;
    private String CityName;
    private int Population;

    public City(int id, String country, String city, int balance){
        this.ID = id;
        this.Country = country;
        this.CityName = city;
        this.Population = balance;
    }

    public int getID() {
        return ID;
    }

    public int getBalance() {
        return Population;
    }

    public String getCountry() {
        return Country;
    }

    public void setAccountID(int accountID) {
        ID = accountID;
    }

    public void setBalance(int population) {
        Population = population;
    }

    public int getPopulation() {
        return Population;
    }

    public String getCityName() {
        return CityName;
    }

    @Override
    public int compareTo(City o) {
        return Integer.compare(getID(), ((City) o).getID());
    }

}
