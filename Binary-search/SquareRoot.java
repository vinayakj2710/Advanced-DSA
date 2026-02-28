public class SquareRoot {
    public static void main (String args[]) {
        int num = 17;
        System.out.println("Square root: " + squareRoot(num));
    }

    public static int squareRoot(int num){
        int l = 0, r=num;
        int ans = Integer.MIN_VALUE;

        if(num < 2) return num;

        while(l<=r){
            int mid = l+(r-l)/2;
            if(mid <= num / mid){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}