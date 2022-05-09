public abstract class Question {

    protected int weight;
    protected String text;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getText() {
        return text;
    }

    abstract String ask();

}
