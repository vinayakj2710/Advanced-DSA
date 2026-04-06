import java.util.*;

class QueueImplementation {

    //Implementation using Array

    static class Queue{
        int[] arr = new  int[5];
        int front = -1, rear = -1;
        int size = 0, cap = arr.length;

        void enqueue(int x){
            if(size == cap){
                System.out.println("The Queue is Full!!");
                return;
            }
            rear = (rear+1) % cap;
            arr[rear] = x;
            size++;
        }

        int dequeue(){
            if(size == 0){
                System.out.println("The Queue is empty!!");
                return -1;
            }
            front = (front+1) % cap;
            size--;
            return arr[front];
        }

        int front(){
            if(size == 0){
                 System.out.println("The Queue is empty!!");
                return -1;
            }
            return arr[(front+1) % cap];
        }

        int size(){
            return size;
        }
        
        boolean isEmpty(){
            return size == 0;
        }
    }

    // Implementation using stack

    static class Queue2{
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        void enqueue (int x){
            st1.push(x);
        }

        int dequeue(){
            if (st1.isEmpty() && st2.isEmpty()) {
                System.out.println("Queue is empty!!");
                return -1;
            }

            if(!st2.isEmpty()){
                return st2.pop();
            }else{
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
                return st2.pop();
            }
        }

        int peek(){
            if (st1.isEmpty() && st2.isEmpty()) {
                System.out.println("Queue is empty!!");
                return -1;
            }

            if(!st2.isEmpty()){
                return st2.peek();
            }else{
                while(!st1.isEmpty()){
                    st2.push(st1.pop());
                }
                return st2.peek();
            }
        }

        int size(){
            return st1.size() + st2.size();
        }

        boolean isEmpty(){
            return st1.size()+st2.size() == 0;
        }
    }

    public static void main(String args[]){
        System.out.println("Implementation of Queue using Array");

        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.front());
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Front after dequeue: " + q.front());
        System.out.println("Size: " + q.size());

        // ===============================
        // Testing Queue using Stacks
        // ===============================

        System.out.println("\nImplementation of Queue using Stacks");

        Queue2 qs = new Queue2();

        // Enqueue elements
        qs.enqueue(100);
        qs.enqueue(200);
        qs.enqueue(300);

        System.out.println("Front (peek): " + qs.peek());

        System.out.println("Dequeued: " + qs.dequeue());

        System.out.println("Front after dequeue: " + qs.peek());

        System.out.println("Size: " + qs.size());

        // Dequeue all
        while (!qs.isEmpty()) {
            System.out.println("Removing: " + qs.dequeue());
        }

        // Edge case test
        System.out.println("Trying to dequeue from empty Queue2:");
        qs.dequeue();

        System.out.println("Trying to peek from empty Queue2:");
        qs.peek();
    }
}