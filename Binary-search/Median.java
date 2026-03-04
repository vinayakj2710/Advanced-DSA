public class Median {
    public static void main (String args[]){
        System.out.println("Find median in a sorted Arrays");

        int[] A = {1, 3, 8};
        int[] B = {7, 9, 10, 11};

        System.out.println("Median: " + findMedian(A, B));
    }

    public static int findMedian (int[] A, int[] B){
        if(A.length > B.length){
            int[] temp = A;
            A = B;
            B = temp;
        }
        int N = A.length;
        int M = B.length;
        int total = N + M;
        int half = (total + 1) / 2;

        int l=0, r = N;

        while(l<=r){
            int mid = (l+r)/2;
            int rem = half-mid;

            int l1 = (mid-1 >= 0) ? A[mid-1] : Integer.MIN_VALUE;
            int l2 = (mid < N) ? A[mid] : Integer.MAX_VALUE;
            int r1 = (rem-1 >= 0) ? B[rem-1] : Integer.MIN_VALUE;
            int r2 = (rem < N) ? B[rem] : Integer.MAX_VALUE;

            if(l1<=r2 && l2<= r1){
                if((N+M) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1 > r2){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}