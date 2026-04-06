import java.util.*;

class QueueImplementation {

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
    }
}