package co.crisi.main.leetcode.removeduplicatesv2;

import java.util.Arrays;
import java.util.Hashtable;

public class Main {

    public static int removeDuplicates(int[] nums) {

        var k = 0;
        var table = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!table.containsKey(nums[i])) {
                table.put(nums[i], 1);
                nums[k] = nums[i];
                k++;
            } else {
                table.replace(nums[i], table.get(nums[i])+1);
                if (table.get(nums[i]) <= 2) {
                    nums[k] = nums[i];
                    k++;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {

        int[] elements = {1,1,1,2,2,3};
        var k = removeDuplicates(elements);
        System.out.println(k);
        System.out.println(Arrays.toString(elements));
    }

}
