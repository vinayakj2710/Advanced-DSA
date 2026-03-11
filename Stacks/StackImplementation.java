import java.util.*;

public class StackImplementation {
    int[] arr = new int[10];
    int tos = -1;

    void push(int x){
        if(tos == arr.length -1){
            System.out.println("Stack Overflow");
            return;
        }
        tos++;
        arr[tos] = x;
    }
    int pop(){
        if(tos == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int rv = arr[tos];
        tos--;
        return rv;
    }
    int peek(){
        if(tos == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[tos];
    }
    boolean isEmpty(){
        return tos == -1;
    }

    public static void main(String args[]){
        System.out.println("Stack Implementation using Array");
        StackImplementation st = new StackImplementation();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.peek());
        System.out.println("Popped element: " + st.pop());
        System.out.println("Is stack empty? " + st.isEmpty());
    }
}