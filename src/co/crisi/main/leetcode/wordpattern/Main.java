package co.crisi.main.leetcode.wordpattern;

import java.util.Hashtable;

public class Main {

    static class Solution {

        public boolean wordPattern(String pattern, String s) {
            var words = s.split(" ");
            if (words.length != pattern.length()) {
                return false;
            }
            var tablePatterns = new Hashtable<Character, String>();
            var tableS = new Hashtable<String, Character>();
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (!tablePatterns.containsKey(c) && !tableS.containsKey(words[i])) {
                    tablePatterns.put(c, words[i]);
                    tableS.put(words[i], c);
                }
            }
            var patternTest = "";
            for (int i = 0; i < words.length; i++) {
                patternTest += tableS.get(words[i]);
            }
            return pattern.equals(patternTest);

        }

    }

    public static void main(String[] args) {
        var s = new Solution();
        var pattern = "aaaa";
        var words = "dog cat cat dog";

        System.out.println(s.wordPattern(pattern, words));
    }

}
