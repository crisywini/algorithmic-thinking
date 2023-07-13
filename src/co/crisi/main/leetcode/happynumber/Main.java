package co.crisi.main.leetcode.happynumber;

import java.util.Hashtable;

public class Main {

    public static boolean isHappy(int n) {
        var pivot = n;
        var table = new Hashtable<Integer, Integer>();
        while (pivot > 1 && !table.containsKey(pivot)) {
            table.put(pivot, sumSquaresDigit(pivot));
            pivot = table.get(pivot);
        }

        return pivot == 1;
    }

    public static int sumSquaresDigit(int n) {
        var sum = 0;
        var mod = n;
        var control = n;
        while (control> 0) {
            mod = control % 10;
            control = (int)control/10;
            sum += mod * mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        var num = 2;
        System.out.println(isHappy(num));
    }

}
