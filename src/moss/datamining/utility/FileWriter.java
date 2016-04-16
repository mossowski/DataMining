package moss.datamining.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import moss.datamining.model.Descriptor;

public class FileWriter {

    public FileWriter() {

    }

    public void saveDescriptors(String fileName, ArrayList<Descriptor> descriptors) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("data\\descriptors\\" + "desc_" + fileName))) {
            for (Descriptor descriptor : descriptors)
                pw.println(descriptor.name);
        } catch (FileNotFoundException anException) {
            anException.printStackTrace();
        }
    }

}
