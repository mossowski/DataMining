package moss.datamining.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import moss.datamining.model.DataDescriptor;
import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;

import static moss.datamining.bon.BagOfNounPhrases.*;
import static moss.datamining.bon.Data.*;

public class FileWriter {

    // --------------------------------------------------------------------------------

    public static void saveDescriptors() {
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

    // --------------------------------------------------------------------------------

    public static void saveDataDescriptors() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("data\\bon\\" + "descriptors.txt"))) {
            for (DataDescriptor dataDescriptor : dataDescriptors) {
                StringBuilder line = new StringBuilder(dataDescriptor.getName() + " " + dataDescriptor.getNumber() + " "
                        + dataDescriptor.getDataNumber());
                pw.println(line);
            }
        } catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
    }

}
