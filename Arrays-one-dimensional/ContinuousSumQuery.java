import java.util.*;

public class ContinuousSumQuery {
    public static void main(String[] args){
        int A = 5;

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1, 2, 10)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 20)));
        B.add(new ArrayList<>(Arrays.asList(2, 5, 25)));

        ArrayList<Integer> res = sumQuery(A, B);

        System.out.println(res);
    }

    public static ArrayList<Integer> sumQuery (int A, ArrayList<ArrayList<Integer>> B){
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(A, 0));
        for(int i=0; i<B.size(); i++){
            int L = B.get(i).get(0);
            int R = B.get(i).get(1);
            int Fact = B.get(i).get(2);

            res.set(L-1, res.get(L-1)+Fact);
            if(R < A){
                res.set(R, res.get(R)-Fact);
            }
        }

        for(int i=1; i<res.size(); i++){
            res.set(i, res.get(i-1)+res.get(i));
        }
        return res;
    }
}