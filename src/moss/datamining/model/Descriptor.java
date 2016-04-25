package moss.datamining.model;

public class Descriptor {

    private String name;
    private int number;

    public Descriptor(String name, int number) {
        this.name = name;
        this.number = number;
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

    public void increaseNumber() {
        this.number++;
    }

}
