package co.crisi.main.leetcode.anagram;

import java.util.Hashtable;

public class Main {

    public static boolean isAnagram(String s, String t) {
        var tableS = createHashtable(s);
        var tableT = createHashtable(t);
        return tableS.equals(tableT);
    }

    public static Hashtable<Character, Integer> createHashtable(String s) {
        var table = new Hashtable<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)) {
                table.replace(c, table.get(c) + 1);
            } else {
                table.put(c, 1);
            }
        }
        return table;
    }


    public static void main(String[] args) {
        var s = "car";
        var t = "rat";
        System.out.println(isAnagram(s, t));
    }

}
