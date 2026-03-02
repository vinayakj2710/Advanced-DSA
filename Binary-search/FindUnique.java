public class FindUnique{
    public static void main(String args[]){
        System.out.println("Find Unique Element in TC - O(log n)");

        // Test case
        int[] arr = {1,1,2,2,3,4,4,5,5};

        int result = findUnique(arr);

        System.out.println("Unique element: " + result);
    }

    public static int findUnique(int[] A){
        int N = A.length;
        // edge cases
        if(N == 0) return -1;
        if(N == 1) return A[0];
        if(A[0] != A[1]) return A[0];
        if(A[N-1] != A[N-2]) return A[N-1];

        int l = 1, r = N-2;
        int ans = -1;

        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] != A[mid+1] && A[mid] != A[mid-1]){
                return A[mid];
            }
            int fo = mid;
            if(A[mid] == A[mid-1]){
                fo = mid-1;
            }
            if(fo % 2 == 0){
                l = fo+2;
            }else{
                r = fo-1;
            }
        }
        return -1;
    }
}