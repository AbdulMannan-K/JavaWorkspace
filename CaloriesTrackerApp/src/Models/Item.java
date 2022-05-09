package Models;

public class Item {

    private String name;
    private double fat;
    private double carbs;
    private double protein;

    public Item(String name, double fat , double carb , double protein){
        setCarbs(carb);
        setFat(fat);
        setProtein(protein);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFat() {
        return fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }
}
