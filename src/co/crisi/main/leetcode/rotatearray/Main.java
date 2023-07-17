package co.crisi.main.leetcode.rotatearray;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void rotate(int[] nums, int k) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
        }

        for(int i = 0; i<nums.length; i++){
            if(i+k-1 < nums.length){
                nums[i+k-1] = stack.pop();
            }else{
                nums[i] = stack.pop();
            }
        }

    }

    public static void main(String[] args) {

        int[] array = {1,2,3,4,5,6,7};
        //             0,1,2,3,4,5,6 indexes
        var k = 1;
        //{7,1,2,3,4,5,6} 1 step
        // 0,1,2,3,4,5,6 indexes
        //{6,7,1,2,3,4,5} 2 steps
        //{5,6,7,1,2,3,4} 3 steps!
        // 0,1,2,3,4,5,6 indexes
        rotate(array, k);
        System.out.println(Arrays.toString(array));
    }

}
