import java.util.*;

public class PerformQueries{
    public static void main(String args[]){
        int[] A = {1, 2, 3, 4};
        int[][] B = {{1, 10},{3, 5}};

        int[] res = solve(A, B);

        for(int n : res){
            System.out.print(n+" ");
        }
    }

    //Add x to all elements from index si to end of array.

    public static int[] solve(int[] A, int[][] B){
        int N = A.length;

        for(int i=0; i<B.length; i++){
            int si = B[i][0], x = B[i][1];
            A[si] += x;
        }

        for(int i=1; i<N; i++){
            A[i] = A[i-1]+A[i];
        }
        return A;
    }
}