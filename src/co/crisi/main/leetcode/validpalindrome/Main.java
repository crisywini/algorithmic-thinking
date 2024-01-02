package co.crisi.main.leetcode.validpalindrome;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static boolean isPalindrome(String s) {
        var wordWithout = s.replace(" ", "");
        var onlyLetters = removeSpecialCharacters(wordWithout).toLowerCase(Locale.ROOT);
        int j = 0;
        for(int i=onlyLetters.length()-1; i>=0 && j<onlyLetters.length(); i--){
            if(onlyLetters.charAt(i) != onlyLetters.charAt(j)){
                return false;
            }
            j++;
        }


        return true;
    }


    private static String removeSpecialCharacters(String s){
        var builder = new StringBuilder();
        var array = s.toCharArray();
        for (char c : array) {
            if(isLetter(c) || isNumber(c)){
                builder.append(c);
            }
        }
        return builder.toString();
    }

    private static boolean isNumber(char character){
        return character == '0' || character == '1' || character == '2'
         || character == '3' || character == '4' || character == '5'
         || character == '6' || character == '7' || character == '8'
         || character == '9';
    }

    private static boolean isLetter(char character){
        return (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z');
    }

    public static void main(String[] args) {
        var s = isPalindrome(" ");
        System.out.println(s);
    }
}
