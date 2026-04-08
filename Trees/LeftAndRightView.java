import java.util.*;

class LeftAndRightView{
    static class Node{
        int val;
        Node right, left;

        Node(int x){
            val = x;
            right = left = null;
        }
    }

    Node root;

    void leftView(Node node){

        if(node == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                Node rn = q.remove();
                if(i == 0){
                    System.out.print(rn.val+" ");
                    if(rn.left != null){
                        q.add(rn.left);
                    }
                    if(rn.right != null){
                        q.add(rn.right);
                    }
                }
            }
            System.out.println(" ");
        }
    }

    void rightView(Node node){

        if(node == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                Node rn = q.remove();
                if(i == (sz-1)){
                    System.out.print(rn.val+" ");
                    if(rn.left != null){
                        q.add(rn.left);
                    }
                    if(rn.right != null){
                        q.add(rn.right);
                    }
                }
            }
            System.out.println(" ");
        }
    }

    public static void main(String args[]){
        System.out.println("Left view of Tree Structure");

        LeftAndRightView tree = new LeftAndRightView();

        // Create tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);

        System.out.print("Left View: \n");
        tree.leftView(tree.root);

        System.out.print("Right View: \n");
        tree.rightView(tree.root);
    }
}