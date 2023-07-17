package co.crisi.main.leetcode.profit;

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


    public static void main(String[] args) {
        var m = new Main();
        int[] prices = {7, 6, 4, 3, 1};
        var res = m.maxProfit(prices);
        assert res == 0 : "Not the correct result";
    }

}
