public class PainterPartition {
    public static void main(String args[]){
        System.out.println("Painter Partition Problem");

        int[] boards = {10, 20, 30, 40};
        int painters = 2;

        int result = solve(boards, painters);

        System.out.println("Boards: {10, 20, 30, 40}");
        System.out.println("Painters: " + painters);
        System.out.println("Minimum time required: " + result);
    }

    public static int solve(int[] A, int P){
        int N = A.length;
        int max = A[0], sum = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, A[i]);
            sum += A[i];
        }

        int ans = 0;

        int l = max, r = sum;
        while(l<=r){
            int mid = l+(r-l)/2;
            boolean flag = isItPossible(A, P, mid);
            if(flag){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }

    private static boolean isItPossible(int[] A, int P, int T){
        int timeleft = T;
        int painters = 1;

        for(int i=0; i<A.length; i++){
            if(A[i] <= timeleft){
                timeleft -= A[i];
            }else{
                painters++;
                timeleft = T - A[i];
            }
        }

        if(painters <= P){
            return true;
        }else{
            return false;
        }
    }
}