import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseLinkedListTwo{
    public static void main(String args[]){
        System.out.println("Reverse linked list two");

        // Create sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReverseLinkedListTwo obj = new ReverseLinkedListTwo();

        head = obj.reverseBetween(head, 2, 4);

        printList(head);
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || B == C) return A;

        ListNode dummy = new ListNode(0);
        dummy.next = A;
        ListNode prev = dummy;

        for (int i = 1; i < B; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for (int i = 0; i < C - B; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head){
        ListNode curr = head;

        while(curr != null){
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }
}