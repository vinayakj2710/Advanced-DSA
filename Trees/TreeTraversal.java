import java.util.*;

class TreeTraversal{

    static class Node {
        int val;
        Node right, left;

        Node (int x){
            val = x;
            right = left = null;
        }
    }

    Node root;

    //Pre-Order Traversal
    void preOrder(Node node){
        if(node == null) return;

        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
        }

    //In-Order Traversal
    void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.val);
        inOrder(node.right);
        }

    //Post-Order Traversal
    void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
        }

    public static void main(String args[]){
        System.out.println("Depth First traversal in tree structure");

        TreeTraversal tree = new TreeTraversal();

        // Creating tree manually
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder Traversal:");
        tree.inOrder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preOrder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postOrder(tree.root);
    }
}