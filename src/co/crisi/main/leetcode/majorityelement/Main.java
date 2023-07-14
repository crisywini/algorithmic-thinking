package co.crisi.main.leetcode.majorityelement;

import java.util.Hashtable;

public class Main {

    public static int majorityElement(int[] nums) {

        var table = countElements(nums);
        var limit = nums.length/2;
        for (Integer key : table.keySet()) {
            if(table.get(key) > limit)
                return key;
        }

        return 0;
    }

    public static Hashtable<Integer, Integer> countElements(int[] nums) {
        var table = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(nums[i])) {
                table.replace(nums[i], table.get(nums[i]) + 1);
            } else {
                table.put(nums[i], 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {

        int[] elements = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(elements));

    }

}
