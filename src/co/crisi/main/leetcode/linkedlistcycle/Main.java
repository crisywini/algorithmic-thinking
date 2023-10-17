package co.crisi.main.leetcode.linkedlistcycle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public class Solution {

        public boolean hasCycle(ListNode head) {

            ListNode pivot = head;
            List<ListNode> visited = new ArrayList<>();

            while (pivot != null) {
                visited.add(pivot);
                pivot = pivot.next;
                if (visited.contains(pivot)) {
                    return true;
                }
            }
            return false;
        }

    }

}
