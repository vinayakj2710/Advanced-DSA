import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode random;

    ListNode(int x){
        val = x;
        next = null;
        random = null;
    }
}

public class DeepCopy{
    public static void main(String args[]){
        System.out.println("Deep copy of a Linked List");

        // Create nodes
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        // Set next pointers: 1 -> 2 -> 3 -> 4
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Set random pointers
        n1.random = n3; // 1 -> 3
        n2.random = n1; // 2 -> 1
        n3.random = n4; // 3 -> 4
        n4.random = n2; // 4 -> 2

        System.out.println("Original List:");
        printList(n1);

        ListNode copiedHead = deepCopy(n1);

        System.out.println("\nCopied List:");
        printList(copiedHead);

    }

    public static ListNode deepCopy(ListNode head){
        if(head == null){
            return head;
        }
        //Insertion of the cloned Node
        ListNode temp = head;

        while(temp != null){
            ListNode cn = new ListNode(temp.val);
            cn.next = temp.next;
            temp.next = cn;
            temp = temp.next.next;
        }

        //Setting random pointers to the cloned Node

        temp = head;
        while(temp != null){
            if(temp.random == null){
                temp.next.random = null;
            }else{
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        //Extraction

        ListNode chead = head.next;
        temp = head;
        ListNode ctemp = chead;
        while(temp != null){
            temp.next = temp.next.next;
            if(ctemp.next != null){
                ctemp.next = ctemp.next.next;
            }
            temp = temp.next;
            ctemp = ctemp.next;
        }
        return chead;
    }

    public static void printList(ListNode A){
        ListNode temp = A;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
}