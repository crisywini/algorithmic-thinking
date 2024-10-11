package co.crisi.main.leetcode.kidscandie;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        var max = Arrays.stream(candies)
                .max()
                .getAsInt();
        return Arrays.stream(candies)
                .mapToObj(i -> i + extraCandies >= max)
                .collect(Collectors.toList());
    }
}
