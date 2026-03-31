import java.util.*;

public class LargestAreaInHistogram {
    public static void main(String args[]){
        System.out.println("Find Largest Area in Histogram using Stacks");

        int[] A = {8,6,2,5,6,5,7,4};

        System.out.print("Answer :" + solve(A));
    }

    public static int solve(int[] A){
        int N = A.length;
        int ans = 0;

        Stack<Integer> st = new Stack<>();

        int[] nsl = new int[N];     // nearest smaller on left

        for(int i=0; i<N; i++){
            while(!st.isEmpty() && A[st.peek()] >= A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        int[] nsr = new int[N];     //nearest smaller on right

        for(int i=N-1; i>=0; i--){
            while(!st.isEmpty() && A[st.peek()] >= A[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i] = N;
            }else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        for(int i=0; i<N; i++){
            ans = Math.max(ans, (nsr[i]-nsl[i] - 1) * A[i]);
        }

        return ans;
    }
}