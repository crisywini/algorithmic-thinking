package co.crisi.main.leetcode.sum;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        var nums = new int[]{3, 2, 4};
        var target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

}
