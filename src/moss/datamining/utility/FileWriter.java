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
                for (Descriptor descriptor : descriptors)
                    pw.println(descriptor.getName());
            } catch (FileNotFoundException anException) {
                anException.printStackTrace();
            }
        }
    }

}
