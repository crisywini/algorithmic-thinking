package co.crisi.main.hackerrank.topview;
import java.util.*;
import java.io.*;
public class Main {

    public static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void topView(Node root) {
        if(root == null){
            return;
        }
        topView(root.left);
        System.out.println(root.data);
        topView(root.right);

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(5);

        topView(root);
    }

}
