import java.util.*;

public class MaxAndMin{

    static final long MOD = 1_000_000_007L;

    public static void main(String args[]){
        System.out.println("Calculate and return the sum of (max-min) of all the sub arrays possible");

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));

        int result = solve(A);
        System.out.println("Answer: " + result); // Expected: 4
    }

    public static int solve(ArrayList<Integer> A) {
        int N = A.size();
        Stack<Integer> st = new Stack<>();
        int[] nsl = new int[N];
        int[] nsr = new int[N];
        int[] ngl = new int[N];
        int[] ngr = new int[N];

        for(int i=0; i<N; i++){
            while(st.size() > 0 && A.get(st.peek()) >= A.get(i)){
                st.pop();
            }
            if(st.size() == 0){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i=N-1; i>=0; i--){
            while(st.size() > 0 && A.get(st.peek()) >= A.get(i)){
                st.pop();
            }
            if(st.size() == 0){
                nsr[i] = N;
            }else{
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i=0; i<N; i++){
            while(st.size() > 0 && A.get(st.peek()) <= A.get(i)){
                st.pop();
            }
            if(st.size() == 0){
                ngl[i] = -1;
            }else{
                ngl[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for(int i=N-1; i>=0; i--){
            while(st.size() > 0 && A.get(st.peek()) <= A.get(i)){
                st.pop();
            }
            if(st.size() == 0){
                ngr[i] = N;
            }else{
                ngr[i] = st.peek();
            }
            st.push(i);
        }

        long maxSum = 0;
        for (int i = 0; i < N; i++) {
            long left = i - ngl[i];
            long right = ngr[i] - i;
            long contri = (A.get(i) * left) % MOD;
            contri = (contri * right) % MOD;
            maxSum = (maxSum + contri) % MOD;
        }

        long minSum = 0;
        for (int i = 0; i < N; i++) {
            long left = i - nsl[i];
            long right = nsr[i] - i;
            long contri = (A.get(i) * left) % MOD;
            contri = (contri * right) % MOD;
            minSum = (minSum + contri) % MOD;
        }

        long ans = (maxSum - minSum + MOD) % MOD;
        return (int) ans;
    }
}