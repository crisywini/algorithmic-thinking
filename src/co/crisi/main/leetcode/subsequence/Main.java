package co.crisi.main.leetcode.subsequence;

public class Main {

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            } else if (j > s.length()) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde"));
    }
}
