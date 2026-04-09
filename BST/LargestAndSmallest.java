import java.util.*;

class LargestAndSmallest{
    static class Node{
        int val;
        Node right, left;

        Node(int x){
            val = x;
            right = left = null;
        }
    }

    Node root;

    /* Find smallest value in BST */
    public static int findSmallest(Node A){
        if(A == null) return -1;
        Node temp = A;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp.val;
    }

    /* Find Largest value in BST */
    public static int findLargest(Node A){
        if(A == null) return -1;
        Node temp = A;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp.val;
    }

    public static void main(String args[]){
        System.out.println("Finding the Largest and Smallest in BST");

        LargestAndSmallest tree = new LargestAndSmallest();

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);

        System.out.println("Smallest element in BST: "+ findSmallest(root));
        System.out.println("Largest element in BST: "+ findLargest(root));
    }
}