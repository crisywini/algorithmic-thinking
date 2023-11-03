package co.crisi.main.leetcode.maxdepthtree;


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

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                int maxLeft = maxDepth(root.left);
                int maxRight = maxDepth(root.right);

                return Math.max(maxLeft, maxRight) + 1;
            }
        }

    }

    public static void main(String[] args) {

    }

}
