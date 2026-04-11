import java.util.*;

class DeletionFromBst{
    static class Node{
        int val;
        Node right, left;

        Node(int x){
            val = x;
            right = left = null;
        }
    }

    Node root;

    public static Node deletionFromBst(Node A, int B){
        if(A == null) return null;

        if(A.val == B){
            if(A.left == null && A.right == null){          //Leaf Node condition
                return null;
            }else if(A.left == null || A.right == null){    //Node with sigle child
                if(A.left == null){
                    return A.right;
                }
                if(A.right == null){
                    return A.left;
                }
            }else{                                          //Node with both the child nodes
                Node temp = A.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                int successor = temp.val;
                temp.val = A.val;
                A.val = successor;
                A.left = deletionFromBst(A.left, successor);
                return A;
            }
        }
        else if(B < A.val){
            return deletionFromBst(A.left, B);
        }else{
            return deletionFromBst(A.right, B);
        }
        return A;
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String args[]){
        System.out.println("Delete element from BST");

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.print("Inorder before deletion: ");
        inorder(root);
        System.out.println();

        // Test deletion
        int key = 50;
        root = deletionFromBst(root, key);

        System.out.print("Inorder after deleting " + key + ": ");
        inorder(root);
        System.out.println();
    }
}