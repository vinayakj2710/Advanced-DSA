public class LocalMinima {
    public static void main(String args[]){
        System.out.println("Local minina in given array");

        int[] arr = {9, 6, 3, 14, 5, 7, 4};
        System.out.println("Local minima: " + solve(arr));
    }

    public static int solve(int[] A){
        int N = A.length;
        if(N == 1) return A[0];
        if(A[0] < A[1]) return A[0];
        if(A[N-1] < A[N-2]) return A[N-1];

        int l=1, r=N-2;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(A[mid] < A[mid+1] && A[mid] < A[mid-1]){
                return A[mid];
            }
            if(A[mid-1] < A[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}