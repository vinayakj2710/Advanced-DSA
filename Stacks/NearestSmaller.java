import java.util.*;

public class NearestSmaller{
    public static void main(String args[]){
        System.out.println("Nearest smaller element");

        NearestSmaller obj = new NearestSmaller();

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));

        ArrayList<Integer> result = obj.prevSmaller(A);

        System.out.println("Input: " + A);
        System.out.println("Nearest Smaller Elements on Left: " + result);

        //Nearest smaller on Right

        int[] B = {4,5,2,10,8};

        int[] res = nearestSmallerRight(B);
        System.out.println("Nearest Smaller Elements on Right: ");
        for(int n : res){
            System.out.print(n+" ");
        }
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int N = A.size();
        Stack <Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<N; i++){
            while(st.size() > 0 && st.peek() >= A.get(i)){
                st.pop();
            } 
            if(st.size() == 0){
                ans.add(-1);
            }else{
                ans.add(st.peek());
            }
            st.push(A.get(i));
        }
        return ans;
    }

    public static int[] nearestSmallerRight (int[] A){
        int N = A.length;
        int[] ans = new int[N];

        Stack<Integer> st = new Stack<>();

        for(int i=N-1; i>=0; i--){
            while(!st.isEmpty() && A[st.peek()] > A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = N;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}