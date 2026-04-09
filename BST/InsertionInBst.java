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

    /* Iterative Method */

    public static TreeNode iterativeInsertionBst(TreeNode A, int B){
        if(A == null) return new TreeNode(B);

        TreeNode temp = A;
        TreeNode prev = null;

        while(temp != null){
            prev = temp;

            if(temp.val == B){
                return A;
            }
            else if(B < temp.val){
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }

        if(B < prev.val){
            prev.left = new TreeNode(B);
        }else{
            prev.right = new TreeNode(B);
        }
        return A;
    }

    /* Inorder Traversal */

    public static void printInorder(TreeNode root){
        if(root == null) return;

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String args[]){
        System.out.println("Insertion in Binary Search Tree");

        TreeNode root = null;

        root = insertionInBST(root, 10);
        root = insertionInBST(root, 5);
        root = iterativeInsertionBst(root, 15);
        root = iterativeInsertionBst(root, 7);

        System.out.print("Inorder: ");
        printInorder(root);
    }
}