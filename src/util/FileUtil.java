/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author jpi
 */
public class FileUtil {
    
    public static void loadCSV(String filename, ArrayList<String[]> list) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); 
                while(reader.ready()) {
                    String[] entries = reader.readLine().split(",");
                    if(!list.contains(entries)) {
                        list.add(entries);
                    }
                }
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void save(String filename, String data) {
        File file = new File(filename);
        boolean append = file.exists();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename,false));
                writer.append(data);
            writer.close();
            System.out.println("Datei " + file.getAbsolutePath()+" geschrieben");
        } catch(Exception ex) {
            System.out.println("Kann " + file.getAbsolutePath()+" nicht schreiben.");
        }
    }
    
    
    
    
}
