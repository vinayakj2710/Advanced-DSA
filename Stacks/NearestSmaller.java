import java.util.*;

public class NearestSmaller{
    public static void main(String args[]){
        System.out.println("Nearest smaller element");

        NearestSmaller obj = new NearestSmaller();

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));

        ArrayList<Integer> result = obj.prevSmaller(A);

        System.out.println("Input: " + A);
        System.out.println("Nearest Smaller Elements: " + result);
    }

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int N = A.size();
        Stack <Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<N; i++){
            while(st.size() > 0 && st.peek() >= A.get(i)){
                st.pop();
            } 
            if(st.size() == 0){
                ans.add(-1);
            }else{
                ans.add(st.peek());
            }
            st.push(A.get(i));
        }
        return ans;
    }
}