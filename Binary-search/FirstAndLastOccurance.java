import java.util.*;

public class FirstAndLastOccurance{
    public static void main(String args[]){
        System.out.println("Find first and last occurance of an element");
        int[] A = {1, 2, 2, 2, 3, 4, 5};
        int K = 2;

        int[] result = solve(A, K);
        System.out.println("First Occurrence: " + result[0]);
        System.out.println("Last Occurrence: " + result[1]);
    }

    //Basic - search the element in an sorted array and return idx
    public static int searchIdx (int[] A, int K){
        int N = A.length;
        int l = 0, r = N-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == K){
                return mid;
            }else if(A[mid] < K){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }

    // Finding the first and last occurance of a given element
    public static int[] solve(int[] A, int K){
        int N = A.length;
        int fo = -1, lo = -1; // fo - first occurance and lo - last occurance
        int l=0, r=N-1;

        int[] ans = new int[2];

        // Finding first occurance
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == K){
                fo = mid;
                r = mid-1;
            }else if(A[mid] < K){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        ans[0] = fo;

        //Resetting boundaries
        l=0; 
        r=N-1;

        //Finding last occurance
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] == K){
                lo = mid;
                l = mid+1;
            }else if(A[mid] < K){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        ans[1] = lo;

        return ans;
    }
}