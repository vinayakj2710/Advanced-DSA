import java.util.*;

public class MergeIntervals {
    public static void main(String args[]){
        System.out.println("Merged Intervals");

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        ArrayList<ArrayList<Integer>> result = mergedIntervals(intervals);

        for (ArrayList<Integer> interval : result) {
            System.out.println(interval);
        }
    }

    private static ArrayList<ArrayList<Integer>> mergedIntervals(int[][] A){
        int N = A.length;
        int si = A[0][0], ei = A[0][1];

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=1; i<N; i++){
            if(A[i][0] <= ei){
                ei = Math.max(A[i][1], ei);
            }else{
                ArrayList<Integer> intervals = new ArrayList<>();
                intervals.add(si);
                intervals.add(ei);
                ans.add(intervals);
                si = A[i][0];
                ei = A[i][1];
            }
        }
        ArrayList<Integer> lastIntervals = new ArrayList<>();
        lastIntervals.add(si);
        lastIntervals.add(ei);
        ans.add(lastIntervals);

        return ans;
    }
}