package gui;

import java.util.ArrayList;
import util.StringUtil;

/**
 *
 * @author Julian Pieles
 */
public class TextTable {
    
    public static void showTable(ArrayList<String[]> list, String... headers) {
        System.out.print(tableHeader(list,headers) + tableBody(list) + "\n");
    }
    
    private static String tableHeader(ArrayList<String[]> list, String[] headers) {
        String header = "";

        header += StringUtil.repeatChar(' ', StringUtil.numberLength(list.size() -1)+1) + " | ";
        for(int i = 0; i < headers.length; i++) {
            header += StringUtil.repeatChar(' ', StringUtil.getLongestWord(list, i).length() - headers[i].length()) + headers[i] + " | ";
        }
        header += "\n";

        header += StringUtil.repeatChar(' ', StringUtil.numberLength(list.size() - 1) +2 ) + "+";
        for(int i = 0; i < headers.length; i++) {
            header += StringUtil.repeatChar('-', StringUtil.getLongestWord(list, i).length() + 2) + "+";
        }
        header += "\n";

        return header;
    }
   
    private static String tableBody(ArrayList<String[]> list) {
        String body = "";
        for(int i = 0; i < list.size(); i++) {
            body += StringUtil.repeatChar(' ', StringUtil.numberLength(list.size() - 1)+1 - StringUtil.numberLength(i+1)) + (i+1) + " | ";
            for(int j = 0; j < list.get(i).length; j++) {
                body += StringUtil.repeatChar(' ', StringUtil.getLongestWord(list, j).length() - list.get(i)[j].length()) + list.get(i)[j] + " | ";
            }
            body += "\n";
        }

        return body;
    }
     
}
