package co.crisi.main.leetcode.mergesortedlinkedlist;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {

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

    }

    public class Solution {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode root = null;

            if(list1 != null){
                if(list2 != null){
                    if(list1.val <= list2.val){
                        root = new ListNode(list1.val);
                        list1 = list1.next;
                    }else{
                        root = new ListNode(list2.val);
                        list2 = list2.next;
                    }
                }else{
                    root = new ListNode(list1.val);
                    list1 = list1.next;
                }
            }else if(list2 != null) {
                root = new ListNode(list2.val);
                list2 = list2.next;
            }

            ListNode pivot = root;

            while(pivot != null){
                if(list1 != null){
                    if(list2 != null){
                        if(list1.val <= list2.val){
                            pivot.next = new ListNode(list1.val);
                            list1 = list1.next;
                        }else{
                            pivot.next = new ListNode(list2.val);
                            list2 = list2.next;
                        }
                    }else{
                        pivot.next = new ListNode(list1.val);
                        list1 = list1.next;
                    }
                }else if(list2 != null) {
                    pivot.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                pivot = pivot.next;
            }

            return root;
        }

    }

}
