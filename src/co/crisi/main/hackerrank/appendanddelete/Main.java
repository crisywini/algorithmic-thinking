package co.crisi.main.hackerrank.appendanddelete;

import java.io.*;

public class Main {

    class Result {

        /*
         * Complete the 'appendAndDelete' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. STRING s
         *  2. STRING t
         *  3. INTEGER k
         *
         *
         * Convert S to T
         */

        public static String appendAndDelete(String s, String t, int k) {
            var counter = 0;

            /*
            * Encontrar el prefijo mínimo
            * */
            for(int i=0; i<s.length(); i++){
                if(i < t.length() ){
                    if(s.charAt(i) == t.charAt(i) ){
                        counter++;
                    }
                }
            }
            if (counter == s.length()){
                return s.length()+t.length() < k || Math.abs(Math.abs(counter-t.length()) - k) %2 ==0 ? "Yes": "No";
            }

            if(counter==0){
                if(k > s.length() + t.length()){
                    return "Yes";
                }
            }
            return (Math.abs(k - counter)) % 2 ==0 ? "Yes" : "No";
        }

    }
    public static void main(String[] args) throws IOException {

        String s = "aba";

        String t = "aba";

        int k = 7;

        String result = Result.appendAndDelete(s, t, k);
        System.out.printf(result);
    }
}
