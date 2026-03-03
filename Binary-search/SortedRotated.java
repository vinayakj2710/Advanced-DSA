public class SortedRotated{
    public static void main(String args[]){
        System.out.println("Find the element in sorted rotated array");

        // Example test case
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int result = solve(arr, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in array.");
        }

    }

    public static int solve(int[] A, int K){
        int N = A.length;
        int l=0, r=N-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == K){
                return mid;
            }else if(A[mid] >= A[0] && K < A[0]){
                l = mid+1;
            }else if(A[mid] < A[0] && K >= A[0]){
                r = mid-1;
            }else{
                if(A[mid] < K){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}