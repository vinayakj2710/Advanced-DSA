import java.util.*;

class BinarySearchTree{

    static class TreeNode{
        int val;
        TreeNode right, left;

        TreeNode(int x){
            val = x;
            right = left = null;
        }
    }

    TreeNode root;

    /* Search in BST */

    /* Recursive Search */
    public static boolean recursiveSearch(TreeNode node, int B){
        if(node == null) return false;

        if(node.val == B) return true;
        else if(node.val < B){
           return recursiveSearch(node.right, B);
        }else{
           return recursiveSearch(node.left, B);
        }
    }

    public static void main(String args[]){
        System.out.println("Binary Search Tree");

        BinarySearchTree tree = new BinarySearchTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        System.out.println(recursiveSearch(root, 7));  // true
        System.out.println(recursiveSearch(root, 20)); // false
    }

}