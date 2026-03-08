import java.util.*;

class BasicProblems {

    // Definition of ListNode
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
        System.out.println("Linked List - Basic Problems");

         // Creating Linked List: 10 -> 20 -> 30 -> 40
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        BasicProblems obj = new BasicProblems();

        int K = 30; // element to search
        int result = obj.searchInLL(head, K);

        if(result == 1){
            System.out.println(K + " found in Linked List");
        } else {
            System.out.println(K + " not found in Linked List");
        }

        // -------- INSERTION TEST --------
        head = insertionInLL(head, 2, 25);

        System.out.println("Linked List after insertion:");
        printList(head);
    }

    //Search in Linked List
    public int searchInLL(ListNode A, int K){
        ListNode temp = A;

        while(temp != null){
            if(temp.val == K){
                return 1;
            }
            temp = temp.next;
        }
        return -1;
    } 

    //Insertion in Linked List
    public static ListNode insertionInLL(ListNode head, int idx, int K){
        ListNode nn = new ListNode(K);
        if(idx == 0){
            nn.next = head;
            head = nn;
            return head;
        }

        ListNode temp = head;
        for(int i=0; i<idx-1 && temp!=null ; i++){
            temp = temp.next;
        }
        if(temp == null){
            return head;
        }
        nn.next = temp.next;
        temp.next = nn;
        return head;
    }


    // Print Linked List
    public static void printList(ListNode head){
        ListNode temp = head;

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}