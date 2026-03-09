import java.util.*;

public class CountOfDistinctElements{
    public static void main(String args[]){
        System.out.println("Count of distict elements using HashSet");

        int[] A = {1, 2, 3, 2, 4, 5, 1, 6, 3};

        System.out.println("Input Array: " + Arrays.toString(A));

        int result = countOfDistinctElements(A);

        System.out.println("Number of distinct elements: " + result);
    }

    public static int countOfDistinctElements(int[] A){
        int N = A.length;
        HashSet<Integer> set = new HashSet<>();
        int ans = 0;
        if(N <= 1){
            return N;
        }
        for(int i=0; i<N; i++){
            set.add(A[i]);
        }
        return set.size();
    }
}