package co.crisi.main.leetcode.ransomnotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String ransomNote = reader.readLine();
        String magazine = reader.readLine();
        System.out.println(canConstruct(ransomNote, magazine));
    }


    /**
     * ransomNote = "aa" magazine = "aab" return true
     *
     * return true if ransomNote can be created by the letters of magazine
     */
    public static boolean canConstruct(String ransomNote, String magazine) {

        var hashTable = fillHashTable(magazine);
        var counter = 0;
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            if (hashTable.containsKey(key) && hashTable.get(key) != 0) {
                hashTable.replace(key, hashTable.get(key) - 1);
                counter++;
            }
        }

        return counter == ransomNote.length();
    }


    public static Hashtable<Character, Integer> fillHashTable(String word) {
        var hashtable = new Hashtable<Character, Integer>();
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if (hashtable.containsKey(key)) {
                hashtable.replace(key, hashtable.get(key) + 1);
            } else {
                hashtable.put(key, 1);
            }
        }
        return hashtable;
    }


}
