package co.crisi.main.leetcode.minimumdifferencebetweenbinarysearchtree;

public class Main {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int getMinimumDifference(TreeNode root) {
            if(root == null){
                return Integer.MAX_VALUE;
            }
            if(root.right == null || root.left==null){
                return root.val;
            }
            if(root.left.left == null && root.left.right == null && root.right.left == null && root.right.right == null){
                return Integer.min(Math.abs(root.val - root.left.val),
                        Math.abs(root.val-root.right.val));
            }
            return Integer.min(getMinimumDifference(root.left), getMinimumDifference(root.right));
        }
    }

    public static void main(String[] args) {

    }
}
