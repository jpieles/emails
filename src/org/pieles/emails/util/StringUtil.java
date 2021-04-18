package util;

import java.util.ArrayList;

/**
 *
 * @author Julian Pieles
 */
public class StringUtil {
    
    public static String repeatChar(char c, int times) {
        String s = "";
        for(int i = 0; i < times ; i++) {
            s += c;
        }
        return s;
    }
    
    public static int numberLength(int number) {
        return String.valueOf(number).length();
    }
    
    public static String getLongestWord(ArrayList<String[]> list, int pos) {
        String longestString = list.get(0)[pos];
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)[pos].length() > longestString.length()) {
                longestString = list.get(i)[pos];
            }
        }
        return longestString;
    }
    
}
