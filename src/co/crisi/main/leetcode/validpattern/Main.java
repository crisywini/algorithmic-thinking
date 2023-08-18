package co.crisi.main.leetcode.validpattern;

import java.util.Hashtable;

public class Main {

    static class Solution {

        public boolean isValid(String s) {
            var table = fillTable(s.toCharArray());

            return table.values().stream().allMatch(e -> e.equals(0));
        }

        public Hashtable<Character, Integer> fillTable(char[] pattern) {
            var table = new Hashtable<Character, Integer>();

            for (int i = 0; i < pattern.length; i++) {
                char c = pattern[i];

                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        if (table.containsKey(c)) {
                            table.replace(c, table.get(c) + 1);
                        } else {
                            table.put(c, 1);
                        }
                        break;
                    case ')':
                        char c1 = '(';
                        if (table.containsKey(c1)) {
                            table.replace(c1, table.get(c1) - 1);
                        } else {
                            table.put(c1, -1);
                        }
                        break;
                    case ']':
                        char c2 = '[';
                        if (table.containsKey(c2)) {
                            table.replace(c2, table.get(c2) - 1);
                        } else {
                            table.put(c2, -1);
                        }
                        break;
                    case '}':
                        char c3 = '{';
                        if (table.containsKey(c3)) {
                            table.replace(c3, table.get(c3) - 1);
                        } else {
                            table.put(c3, -1);
                        }
                        break;
                }

            }
            return table;
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isValid("()[]{}"));

    }

}
