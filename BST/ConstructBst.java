import java.util.*;

class ConstructBst{
    static class Node{
        int val;
        Node right, left;

        Node(int x){
            val = x;
            right = left = null;
        }
    }

    Node root;

    public static Node construct(int[] A, int lo, int hi){

        if(lo > hi) return null;
        if(lo == hi) return new Node(A[lo]);

        int mid = (lo+hi)/2;
        Node root = new Node(A[mid]);
        root.left = construct(A, lo, mid-1);
        root.right = construct(A, mid+1, hi);

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main (String args[]){
        System.out.println("Construct a Balanced BST using a sorted Array");

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        Node root = construct(arr, 0, arr.length - 1);

        inorder(root);
    }
}