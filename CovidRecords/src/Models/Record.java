package Models;

public class Record {

    private String countryName;
    private String continentName;
    private String date;
    private int newCases;
    private int newDeaths;
    private long population;
    private int peopleVaccinated;

    public Record(String countryName,String continentName,String date,int newCases, int newDeaths, long population, int peopleVaccinated){
        setCountryName(countryName);
        setContinentName(continentName);
        setDate(date);
        setNewCases(newCases);
        setNewDeaths(newDeaths);
        setPopulation(population);
        setPeopleVaccinated(peopleVaccinated);
    }

    public String getContinentName() {
        return continentName;
    }

    public int getNewCases() {
        return newCases;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getDate() {
        return date;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public long getPopulation() {
        return population;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public void setPeopleVaccinated(int peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
