import java.util.*;

public class MaxSubArraySum {
    public static void main (String args[]){
        int[] A = {-2,3,4,-1,5,-10,7};
        ArrayList<Integer> result = maxSubArrSum(A);
        System.out.println("Max Sum: " + result.get(0));
        System.out.println("Start Index: " + result.get(1));
        System.out.println("End Index: " + result.get(2));
    }

    //Kadan's Algorithm 
    public static ArrayList<Integer> maxSubArrSum (int[] A){
        int N = A.length;
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        int sum  = 0;

        // Initializing start and end index
        int si = -1, ei = -1; 
        int tempStart = 0;
        for(int i=0; i<N; i++){
            sum += A[i];
            if(sum < 0){
                sum = 0;
                tempStart = i+1;
            }
            if(maxSum < sum){
                maxSum = sum;
                si = tempStart;
                ei = i;
            }
        }

        res.add(maxSum);
        res.add(si );
        res.add(ei);

        return res;
    }
}