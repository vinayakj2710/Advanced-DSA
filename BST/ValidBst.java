import java.util.*;

class ValidBst{

    static class Node{
        int val;
        Node right, left;

        Node(int x){
            val = x;
            right = left = null;
        }
    }

    static boolean isBst = true;
    static Node prev = null;

    public static boolean validBst (Node A){
        isBst = true;
        prev = null;
        inOrder(A);
        return isBst;
    }

    public static void inOrder(Node curr){
        //Edge case
        if(curr == null) return;

        //Using inorder to validate BST
        inOrder(curr.left);

        if(prev != null && prev.val > curr.val){
            isBst = false;
        }
        prev = curr;
        inOrder(curr.right);
    }

    public static void main(String args[]){
        System.out.println("Validating given tree is a BST or not!! ");
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);

        System.out.println(validBst(root)); // true
    }
}