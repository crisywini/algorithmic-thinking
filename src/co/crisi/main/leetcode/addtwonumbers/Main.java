package co.crisi.main.leetcode.addtwonumbers;

import java.util.Optional;

public class Main {

    /**
     * Definition for singly-linked list.
     */

    public static class ListNode {

        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            ListNode pivot = this;

            while (pivot != null) {
                System.out.print(pivot.val);
                pivot = pivot.next;
            }
            System.out.println();
        }

    }

    public static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode root = null;
            ListNode tail = null;
            ListNode pivotL1 = l1;
            ListNode pivotL2 = l2;
            int l1val = 0;
            int l2val = 0;
            int sum = 0;
            int quotient = 0;
            while (pivotL1 != null || pivotL2 != null || quotient != 0) {
                l1val = Optional.ofNullable(pivotL1).map(node -> node.val).orElse(0);
                l2val = Optional.ofNullable(pivotL2).map(node -> node.val).orElse(0);
                sum = l1val + l2val + quotient;
                quotient = sum / 10;

                if (sum >= 10) {
                    if (root == null) {
                        root = new ListNode(sum % 10);
                        tail = root;
                    } else {
                        tail.next = new ListNode(sum % 10);
                        tail = tail.next;
                    }
                } else {
                    if (root == null) {
                        root = new ListNode(sum);
                        tail = root;
                    } else {
                        tail.next = new ListNode(sum);
                        tail = tail.next;
                    }
                }
                pivotL1 = pivotL1 != null ? pivotL1.next : null;
                pivotL2 = pivotL2 != null ? pivotL2.next : null;

            }

            return root;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = new Solution().addTwoNumbers(l1, l2);

        l1.print();
        l2.print();
        result.print();

    }

}
