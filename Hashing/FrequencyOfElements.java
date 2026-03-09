import java.util.*;

public class FrequencyOfElements {
    public static void main(String args[]){
        System.out.println("Hashing Problems");

        int[] A = {1,2,5,4,6,3,2,4,3,2,1,1};
        int[] B = {1,2,3,4,5,8};

        System.out.println("Array A: " + Arrays.toString(A));
        System.out.println("Query Array B: " + Arrays.toString(B));
        System.out.println();

        ArrayList<Integer> result = frequencyOfElements(A, B);

        System.out.println("Frequencies:");
        for(int i = 0; i < B.length; i++){
            System.out.println("Element " + B[i] + " -> " + result.get(i));
        }
    }

    public static ArrayList<Integer> frequencyOfElements(int[] A, int[] B){
        int N = A.length;
        int M = B.length;
        
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            if(map.containsKey(A[i])){
                int prev = map.get(A[i]);
                map.put(A[i], prev+1);
            }else{
                map.put(A[i], 1);
            }
        }

        for(int i=0; i<M; i++){
            if(map.containsKey(B[i])){
                ans.add(map.get(B[i]));
            }else{
                ans.add(0);
            }
        }

        return ans;
    }
}  