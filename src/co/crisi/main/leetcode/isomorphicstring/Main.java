package co.crisi.main.leetcode.isomorphicstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        System.out.println(isIsomorphic(s, t));

    }

    public static boolean isIsomorphic(String s, String t) {

        var h1 = new Hashtable<Character, Character>();
        var h2 = new Hashtable<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!h2.containsKey(t.charAt(i))) {
                h2.put(t.charAt(i), s.charAt(i));
            }
            if (!h1.containsKey(s.charAt(i))) {
                h1.put(s.charAt(i), t.charAt(i));
            }
        }

        var eq = "";
        for (int i = 0; i < t.length(); i++) {
            var key = s.charAt(i);
            eq += h1.get(key);
        }

        return eq.equals(t);
    }


}
