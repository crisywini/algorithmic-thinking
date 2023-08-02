package co.crisi.main.leetcode.rotatearray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    class Element {
        private int value;
        public Element next;
        public Element previous;

        public Element(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        public int getValue(){
            return this.value;
        }
    }

    class CircularList {
        private Element root;
        private Element last;

        public CircularList(Element root) {
            this.root = root;
            last = root;
            this.root.next = last;
            this.root.previous = last;
        }

        public void add(Element element) {
            if (root == null) {
                root = element;
                last = root;
                root.next = null;
            } else {
                if (last == root) {
                    last = element;
                    root.next = last;
                    last.previous = root;
                } else {
                    element.previous = last;
                    last.next = element;
                    last = element;
                }
                last.next = this.root;
            }
            root.previous = last;
        }

        public void moveToRight() {
            this.root = this.root.previous;
        }

        public Integer[] toArray() {
            Element pivot = this.root;
            List<Integer> elements = new ArrayList<>();
            elements.add(this.root.getValue());
            while (pivot.next != this.root) {
                elements.add(pivot.next.getValue());
                pivot = pivot.next;
            }
            return elements.toArray(new Integer[0]);
        }
    }

    public void rotate(int[] nums, int k) {

        Element root = new Element(nums[0]);
        CircularList list = new CircularList(root);

        for (int i = 1; i < nums.length; i++) {
            list.add(new Element(nums[i]));
        }
        for(int i = 0; i<k; i++){
            list.moveToRight();
        }
        var arr = list.toArray();
        for(int i = 0; i<nums.length; i++){
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {

        int[] array = {1};
        //             0,1,2,3,4,5,6 indexes
        var k = 0;
        //{7,1,2,3,4,5,6} 1 step
        // 0,1,2,3,4,5,6 indexes
        //{6,7,1,2,3,4,5} 2 steps
        //{5,6,7,1,2,3,4} 3 steps!
        // 0,1,2,3,4,5,6 indexes
        Main main = new Main();
        main.rotate(array, k);
        System.out.println(Arrays.toString(array));
    }

}
