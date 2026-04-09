import java.util.*;

class InsertionInBst{

    static class TreeNode{
        int val;
        TreeNode right, left;

        TreeNode(int x){
            val = x;
            right = left = null;
        }
    }

    /* Recursive Method */
    public static TreeNode insertionInBST (TreeNode A, int B){
        if(A == null) return new TreeNode(B);

        if(A.val > B){
            A.left = insertionInBST(A.left, B);
        }else{
            A.right = insertionInBST(A.right, B);
        }

        return A;
    }

    public static void main(String args[]){
        System.out.println("Insertion in Binary Search Tree");

        TreeNode root = null;

        root = insertionInBST(root, 10);
        root = insertionInBST(root, 5);
        root = insertionInBST(root, 15);
        root = insertionInBST(root, 7);

        System.out.println("Inserted nodes successfully!");
    }
}