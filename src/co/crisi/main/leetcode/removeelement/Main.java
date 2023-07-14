package co.crisi.main.leetcode.removeelement;

import java.util.Arrays;

public class Main {

    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {

        int[] nums= {3,2,2,3};
        var val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }

}
