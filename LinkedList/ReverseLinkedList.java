import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedList{
    public static void main (String args[]){
        System.out.println("Reverse the given Linked List");

        // Create sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverse(head);

        printList(head);
    }

    public static ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        //Preserve previous and current node
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head = prev;
        return head;
    }

    //Print Linked list

    public static void printList(ListNode A){
        ListNode temp = A;
        while(temp != null){
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
}