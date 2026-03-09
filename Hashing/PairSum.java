import java.util.*;

public class PairSum{
    public static void main(String args[]){
        System.out.println("Hashing - pair sum K problem");
        int[] A = {3, 5, 1, 7, 9, 2};
        int K = 10;

        System.out.println("Array: " + Arrays.toString(A));
        System.out.println("Target Sum: " + K);

        int result = pairSum(A, K);

        if(result == 1){
            System.out.println("Pair with sum " + K + " exists.");
        }else{
            System.out.println("No pair with sum " + K + " found.");
        }
    }

    public static int pairSum(int[] A, int K){
        int N = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<N; i++){
            if(map.containsKey(A[i])){
                int prev = map.get(A[i]);
                map.put(A[i], prev+1);
            }else{
                map.put(A[i], 1);
            }
        }

        for(int i=0; i<N; i++){
            int diff = K - A[i];
            if(A[i] == diff && map.get(A[i]) > 1){
                return 1;
            }else if(A[i] != diff && map.containsKey(diff)){
                return 1;
            }
        }
        return -1;
    }
}