package co.crisi.main.leetcode.mergesortedarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    class Solution {

        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            var queue1 = fillQueue(nums1, m);
            var queue2 = fillQueue(nums2, n);
            for (int i = 0; i < n + m; i++) {
                if (queue1.isEmpty()) {
                    if (!queue2.isEmpty()) {
                        nums1[i] = queue2.poll();
                    }
                } else {
                    if (queue2.isEmpty()) {
                        nums1[i] = queue1.poll();
                    } else {
                        if (queue1.peek() < queue2.peek()) {
                            nums1[i] = queue1.poll();
                        } else {
                            nums1[i] = queue2.poll();
                        }
                    }
                }
            }
        }

        public static Queue<Integer> fillQueue(int[] nums1, int n) {
            var out = new PriorityQueue<Integer>();
            for (int i = 0; i < n; i++) {
                out.add(nums1[i]);
            }
            return out;
        }


    }

    public static void main(String[] args) {

        int n = 3;
        int m = 6;
        int[] nums1 = {-1,0,0,3,3,3,0,0,0};
        int[] nums2 = {1,2,2};

        Solution.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));


    }


}
