package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Julian Pieles
 */
public class FileUtil {
    
    public static void loadCSV(String filename, ArrayList<String[]> list) {
        System.out.println("Loading from " + filename);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); 
                while(reader.ready()) {
                    String[] entries = reader.readLine().split(",");
                    if(!list.contains(entries)) {
                        list.add(entries);
                    }
                }
            
        }catch(Exception ex) {
            System.out.println("Cannot load file");
        }
    }
    
    public static void save(String filename, String data) {
        File file = new File(filename);
        boolean append = file.exists();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename,false));
                writer.append(data);
            writer.close();
            System.out.println("File " + file.getAbsolutePath()+" written");
        } catch(Exception ex) {
            System.out.println("Cannot write file " + file.getAbsolutePath());
        }
    }
    
    
    
    
}
