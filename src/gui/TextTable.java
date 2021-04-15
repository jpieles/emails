/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import util.StringUtil;

/**
 *
 * @author Julian Pieles
 */
public class TextTable {
    
    public static void showTable(ArrayList<String[]> list, String... headers) {
        showTableHeader(list,headers);
        showTableBody(list);
        System.out.print("\n");
    }
    
    private static void showTableHeader(ArrayList<String[]> list, String[] headers) {
        System.out.print(StringUtil.repeatChar(' ', StringUtil.numberLength(list.size() -1)+1) + " | ");
        for(int i = 0; i < headers.length; i++) {
            System.out.print(StringUtil.repeatChar(' ', StringUtil.getLongestWord(list, i).length() - headers[i].length()) + headers[i] + " | ");
        }
        System.out.print("\n");
        System.out.print(StringUtil.repeatChar(' ', StringUtil.numberLength(list.size() - 1) +2 ) + "+");
        for(int i = 0; i < headers.length; i++) {
            System.out.print(StringUtil.repeatChar('-', StringUtil.getLongestWord(list, i).length() + 2) + "+");
        }
        System.out.print("\n");
    }
    
    private static void showTableBody(ArrayList<String[]> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.print(StringUtil.repeatChar(' ', StringUtil.numberLength(list.size() - 1)+1 - StringUtil.numberLength(i+1)) + (i+1) + " | ");
            for(int j = 0; j < list.get(i).length; j++) {
                System.out.print(StringUtil.repeatChar(' ', StringUtil.getLongestWord(list, j).length() - list.get(i)[j].length()) + list.get(i)[j] + " | ");
            }
            System.out.print("\n");
        }
    }
     
}
