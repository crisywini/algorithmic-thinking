package co.crisi.main.leetcode.copylistwithrandompointer;

import java.util.Hashtable;
import java.util.Optional;

public class Main {


    static class Node {

        int val;

        Node next;

        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public void print(){
            var pivot = this;
            System.out.print("[ ");
            while(pivot != null){
                System.out.print("["+ pivot.val+", "+Optional.ofNullable(pivot.random).map(n -> n.val).orElse(null)+"] ");
                pivot = pivot.next;
            }
            System.out.print("]\n");

        }

    }


    static class Solution {

        public Node copyRandomList(Node head) {
            var newHead = new Node(head.val);
            newHead.random = Optional.ofNullable(head.random).map(n -> new Node(n.val)).orElse(null);
            var tail = newHead;

            var pivot = head.next;

            while (pivot != null) {
                tail.next = new Node(pivot.val);
                tail = tail.next;
                tail.random = Optional.ofNullable(pivot.random).map(n -> new Node(n.val)).orElse(null);
                pivot = pivot.next;
            }
            return newHead;
        }


    }

    public static void main(String[] args) {
        var head = new Node(7);
        var node1 = new Node(13);
        head.next = node1;
        var node2 = new Node(11);
        node1.next = node2;
        var node3 = new Node(10);
        node2.next = node3;
        var node4 = new Node(1);
        node3.next = node4;
        node1.random = head;
        node2.random = node4;
        node3.random = node2;
        node4.random = head;

        var newList = new Solution().copyRandomList(head);

        head.print();
        newList.print();
    }

}
