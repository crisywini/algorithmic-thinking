package co.crisi.main.leetcode.longestcommonprefix;

import java.util.Hashtable;
import java.util.Random;

public class Main {

    static class Solution{
        public String longestCommonPrefix(String[] strs) {
            var prefixes = new Hashtable<String, Long>();

            for(int i = 0; i<strs.length; i++){
                fillPrefixes(strs[i], prefixes);
            }
            var keyIterator = prefixes.keySet().iterator();
            while(keyIterator.hasNext()){
                var k = keyIterator.next();
                if(prefixes.get(k) < strs.length){
                    keyIterator.remove();
                }
            }
            var max = "";
            var finalIterator = prefixes.keySet().iterator();
            while(finalIterator.hasNext()){
                var k = finalIterator.next();
                max = k.length() > max.length() ? k : max;
            }

            return max;
        }
        public void fillPrefixes(String word, Hashtable<String, Long> prefixes) {
            for(int i=1; i<=word.length(); i++){
                var k = word.substring(0, i);
                if(prefixes.containsKey(k)){
                    prefixes.replace(k, prefixes.get(k)+1);
                }else{
                    prefixes.put(k, 1L);
                }
            }
        }
    }

    public static void main(String[] args) {

        var solution = new Solution();
        String[] strs = new String[200];
        var word = get200Characters();
        System.out.println(word.length());
        for(int i = 0; i<strs.length; i++){
            strs[i] = word;
        }

        System.out.println(solution.longestCommonPrefix(strs));

    }

    public static String get200Characters(){
        var out = "";
        for(int i = 0; i<200; i++){
            out += "a";
        }
        return out;
    }
}
