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

    public static void main (String args[]){
        System.out.println("Construct a Balanced BST using a sorted Array");
    }
}