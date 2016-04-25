package moss.datamining.model;

public class Descriptor {

    private String name;
    private int documentNumber;
    private int dataNumber;

    public Descriptor(String name, int number) {
        this.name = name;
        this.documentNumber = number;
        this.dataNumber = 1;
    }

    // --------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    // --------------------------------------------------------------------------------

    public int getDocumentNumber() {
        return documentNumber;
    }

    // --------------------------------------------------------------------------------

    public void setDocumentNumber(int number) {
        this.documentNumber = number;
    }

    // --------------------------------------------------------------------------------

    public void increaseDocumentNumber() {
        this.documentNumber++;
    }

    // --------------------------------------------------------------------------------

    public int getDataNumber() {
        return dataNumber;
    }

    // --------------------------------------------------------------------------------

    public void increaseDataNumber() {
        this.dataNumber++;
    }

}
