package moss.datamining.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import moss.datamining.model.DataDescriptor;
import moss.datamining.model.Descriptor;
import moss.datamining.model.Document;

import static moss.datamining.bon.Data.*;
import static moss.datamining.utility.Settings.BON_DATA_PATH;
import static moss.datamining.utility.Settings.DESCRIPTORS_DATA_PATH;

public class FileWriter {

    // --------------------------------------------------------------------------------

    public static void saveDescriptors() {
        for (Document document : documents.values()) {
            String fileName = document.getName();
            HashMap<String, Descriptor> descriptors = document.getDescriptors();
            Map<String, Descriptor> treeMap = new TreeMap<String, Descriptor>(descriptors);
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(DESCRIPTORS_DATA_PATH + "desc_" + fileName))) {
                for (Descriptor descriptor : treeMap.values()) {
                    StringBuilder line = new StringBuilder(
                            descriptor.getName() + " " + descriptor.getNumber() + " " + descriptor.getWeight());
                    pw.println(line);
                }
            } catch (FileNotFoundException anException) {
                System.out.println("File not found!" + anException);
            }
        }
    }

    // --------------------------------------------------------------------------------

    public static void saveDataDescriptors() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(BON_DATA_PATH + "descriptors.txt"))) {
            Map<String, DataDescriptor> treeMap = new TreeMap<String, DataDescriptor>(dataDescriptors);
            for (DataDescriptor dataDescriptor : treeMap.values()) {
                StringBuilder line = new StringBuilder(dataDescriptor.getName() + " " + dataDescriptor.getNumber() + " "
                        + dataDescriptor.getDataNumber());
                pw.println(line);
            }
        } catch (FileNotFoundException anException) {
            System.out.println("File not found!" + anException);
        }
    }

    // --------------------------------------------------------------------------------

    public static void removeFiles() {
        // removes descriptors file in bon directory
        File descriptorsFile = new File(BON_DATA_PATH + "descriptors.txt");
        descriptorsFile.delete();
        // removes all files in descriptors directory
        File descriptorsDirectory = new File(DESCRIPTORS_DATA_PATH);
        for (File file : descriptorsDirectory.listFiles())
            file.delete();
    }

}
