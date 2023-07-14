package co.crisi.main.leetcode.removeduplicates;

import java.util.Arrays;
import java.util.Hashtable;

public class Main {

    public static int removeDuplicates(int[] nums) {

        var table = new Hashtable<Integer, Integer>();
        var k = 0;
        for(int i=0; i<nums.length; i++){
            if(!table.containsKey(nums[i])){
                table.put(nums[i], 1);
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));

    }

}
