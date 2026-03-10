import java.util.*;

public class SubArrayWithGivenSum{
    public static void main (String args[]){
        System.out.println("---- Test Case 1 (Only Positive Numbers) ----");

        int[] A1 = {1,2,3,4,5};
        int B1 = 9;

        System.out.println("Sliding Window Result: " + solve(A1, B1));
        System.out.println("Hashing Result: " + solveTwo(A1, B1));


        System.out.println("\n---- Test Case 2 (Contains Negative Numbers) ----");

        int[] A2 = {10, 2, -2, -20, 10};
        int B2 = -10;

        System.out.println("Sliding Window Result: " + solve(A2, B2));
        System.out.println("Hashing Result: " + solveTwo(A2, B2));
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

    //Using Hashing technique

    public static ArrayList<Integer> solveTwo(int[] A, int B){
        int N = A.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Long, Integer> map = new HashMap<>();

        long prefixSum = 0;

        for(int i=0; i<N; i++){
            prefixSum += A[i];
            if(prefixSum == B){
                for(int j=0; j<=i; j++){
                    ans.add(A[j]);
                }
                return ans;
            }
            if(map.containsKey(prefixSum-B)){
                int start = map.get(prefixSum-B) + 1;
                for(int j=start; j<=i; j++){
                    ans.add(A[j]);
                }
                return ans;
            }
            map.put(prefixSum, i);
        }
        ans.add(-1);
        return ans;
    }
}