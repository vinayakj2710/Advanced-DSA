import java.util.*;

public class SlidingWindowMax{
    public static void main (String args[]){
        System.out.println("Find max of every sub Array of size K");

        System.out.println("Find max of every sub Array of size K");

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7));
        int K = 3;

        ArrayList<Integer> result = solve(A, K);

        System.out.println("Result: " + result);
    }

    public static ArrayList<Integer> solve (ArrayList<Integer> A, int K){
        int N = A.size();

        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<K; i++){
            while(!dq.isEmpty() && A.get(dq.getLast()) <= A.get(i)){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        ans.add(A.get(dq.getFirst()));

        for(int i=K; i<N; i++){
            if (!dq.isEmpty() && dq.getFirst() <= i - K) {
                dq.removeFirst();
            }

            while(!dq.isEmpty() && A.get(dq.getLast()) <= A.get(i)){
                dq.removeLast();
            }
            dq.addLast(i);
            ans.add(A.get(dq.getFirst()));
        }
        return ans;
    }
}