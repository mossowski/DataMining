package moss.datamining.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;

public class FileWriter {

    public FileWriter() {

    }

    // --------------------------------------------------------------------------------

    public void saveDescriptors(ArrayList<Document> documents) {
        for (Document document : documents) {
            String fileName = document.getName();
            ArrayList<Descriptor> descriptors = document.getDescriptors();
            try (PrintWriter pw = new PrintWriter(new FileOutputStream("data\\descriptors\\" + "desc_" + fileName))) {
                for (Descriptor descriptor : descriptors) {
                    StringBuilder line = new StringBuilder(descriptor.getName() + " " + descriptor.getNumber());
                    pw.println(line);
                }
            } catch (FileNotFoundException anException) {
                System.out.println("File not found!" + anException);
            }
        }
    }

}
