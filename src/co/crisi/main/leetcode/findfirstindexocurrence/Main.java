package co.crisi.main.leetcode.findfirstindexocurrence;

public class Main {

    static class Solution {

        public int strStr(String haystack, String needle) {

            var haystackArr = haystack.toCharArray();
            var needleArr = needle.toCharArray();
            var pivotIndex = 0;
            var index = -1;
            for (int i = 0; i < haystackArr.length; i++) {
                if (haystackArr[i] == needleArr[pivotIndex]) {
                    if (contains(needleArr, haystackArr, i)) {
                        return i;
                    }
                }
            }

            return index;
        }

        public boolean contains(char[] needle, char[] haystack, int haystackIndexOccurrence) {
            var j = 0;
            var counter = 0;
            for (int i = haystackIndexOccurrence; i < haystack.length && j < needle.length; i++, j++) {
                if (needle[j] != haystack[i]) {
                    return false;
                }
                counter++;
            }
            return counter == needle.length;
        }


    }

    public static void main(String[] args) {
        var solution = new Solution();

        var haystack = "aaa";
        var needle = "aaaa";
        var s = solution.strStr(haystack, needle);
        System.out.println(s);
    }

    public static String getMaximumBitch(char a){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<10*10*10*10; i++){
            s.append(a);
        }
        return s.toString();
    }

}
