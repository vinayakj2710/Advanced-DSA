import java.util.*;

public class SubArrayWithGivenSum{
    public static void main (String args[]){
        System.out.println("Sub array with given sum");

        int[] A = {1, 2, 3, 4, 5};
        int B = 9;

        System.out.println("Array: " + Arrays.toString(A));
        System.out.println("Target Sum: " + B);

        ArrayList<Integer> result = solve(A, B);

        System.out.println("Subarray: " + result);
    }

    // Using sliding widow technique 
    public static ArrayList<Integer> solve(int[] A, int B){
        int N = A.length;
        ArrayList<Integer> ans = new ArrayList<>();

        int start = 0;
        long sum = 0;

        for(int end=0; end < N; end++){
            sum += A[end];
            while(sum > B && start <= end){
                sum -= A[start];
                start++;
            }
            if(sum == B){
                for(int i=start; i<=end; i++){
                    ans.add(A[i]);
                }
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }
}