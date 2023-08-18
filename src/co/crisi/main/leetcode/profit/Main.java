package co.crisi.main.leetcode.profit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public int maxProfit(int[] prices) {
        var max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                var profit = prices[j] - prices[i];
                max = profit >= 0 && profit > max ? profit : max;
            }
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        var m = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        var list = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
        int[] prices = list.stream().mapToInt( i -> i ).toArray();
        var res = m.maxProfit(prices);
        System.out.println(res);
        assert res == 999 : "Not the correct result";
    }

}
