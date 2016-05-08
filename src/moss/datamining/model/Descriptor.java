package moss.datamining.model;

public class Descriptor {

    private String name;
    private int number;
    private double weight;

    public Descriptor(String name, int number) {
        this.name = name;
        this.number = number;
        this.weight = 0;
    }

    // --------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    // --------------------------------------------------------------------------------

    public int getNumber() {
        return number;
    }

    // --------------------------------------------------------------------------------

    public void setNumber(int number) {
        this.number = number;
    }

    // --------------------------------------------------------------------------------

    public void increaseNumber() {
        this.number++;
    }

    // --------------------------------------------------------------------------------

    public double getWeight() {
        return weight;
    }

    // --------------------------------------------------------------------------------

    public void setWeight(double weight) {
        this.weight = weight;
    }

}
