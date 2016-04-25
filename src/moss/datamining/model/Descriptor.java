package moss.datamining.model;

public class Descriptor {

    private String name;
    private int numberOfDescriptors;

    public Descriptor(String name) {
        this.name = name;
        setNumberOfDescriptors(0);
    }

    // --------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    // --------------------------------------------------------------------------------

    public int getNumberOfDescriptors() {
        return numberOfDescriptors;
    }

    // --------------------------------------------------------------------------------

    public void setNumberOfDescriptors(int numberOfDescriptors) {
        this.numberOfDescriptors = numberOfDescriptors;
    }

}
