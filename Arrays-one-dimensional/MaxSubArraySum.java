public class MaxSubArraySum {
    public static void main (String args[]){
        int[] A = {-2,3,4,-1,5,-10,7};
        System.out.println(maxSubArrSum(A));
    }

    //Kadan's Algorithm 
    public static int maxSubArrSum (int[] A){
        int N = A.length;
        int maxSum = Integer.MIN_VALUE;
        int sum  = 0;
        for(int i=0; i<N; i++){
            sum += A[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}