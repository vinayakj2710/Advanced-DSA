import java.util.*;

class LevelOrder{

    static class Node{
        int val;
        Node right, left;

        Node(int x){
            val = x;
            right = left = null;
        }
    }

    Node root;

    void levelOrder(Node node){
        if(node == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(q.size() > 0){
            int sz = q.size();

            for(int i=0; i<sz; i++){
                Node rn = q.remove();
                System.out.print(rn.val+" ");
                if(rn.left != null){
                    q.add(rn.left);
                }
                if(rn.right != null){
                    q.add(rn.right);
                }
            }
            System.out.println(" ");
        }
    }

    public static void main(String args[]){
        System.out.println("Breadth first traversal or Level order traversal");

        LevelOrder tree = new LevelOrder();

        // Create tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.levelOrder(tree.root);
    }
}