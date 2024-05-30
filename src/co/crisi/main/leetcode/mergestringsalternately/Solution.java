package co.crisi.main.leetcode.mergestringsalternately;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        var result = "";
        var w1 = word1.toCharArray();
        var w2 = word2.toCharArray();
        var sb = new StringBuilder();
        var limit = Math.max(w1.length, w2.length);

        for(int i = 0; i<limit; i++){
            if(i<w1.length && i<w2.length){
                sb.append(Character.toString(w1[i])).append(Character.toString(w2[i]));
            } else if(i<w1.length && i >= w2.length){
                sb.append(word1.substring(i));
                return sb.toString();
            } else if(i>= w1.length && i < w2.length){
                sb.append(word2.substring(i));
                return sb.toString();
            }
        }
        return sb.toString();
    }
}