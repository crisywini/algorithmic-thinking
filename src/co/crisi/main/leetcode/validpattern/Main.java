package co.crisi.main.leetcode.validpattern;

import java.util.Stack;

public class Main {

    static class Solution {

        public boolean isValid(String s) {

            Stack<Character> a = new Stack<>();
            var array = s.toCharArray();

            for (int i = 0; i < array.length; i++) {
                char c = array[i];
                if (c == ')') {
                    if (!a.isEmpty() && a.peek() == '(') {
                        a.pop();
                    }else{
                        a.push(c);
                    }
                } else if (c == ']') {
                    if (!a.isEmpty() && a.peek() == '[') {
                        a.pop();
                    }else{
                        a.push(c);
                    }
                } else if (c == '}') {
                    if (!a.isEmpty() && a.peek() == '{') {
                        a.pop();
                    }else{
                        a.push(c);
                    }
                } else {
                    a.push(c);
                }
            }

            return a.isEmpty();
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isValid("[](){}()}{"));

    }

}
