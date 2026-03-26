import java.util.*;

public class DoubleCharTrouble{
    public static void main(String[] args){
        System.out.println("Double character trouble problem");

        String result = solve("abccbc");
        System.out.println(result);
    }

    public static String solve(String A){
        int N = A.length();

        Stack<Character> st = new Stack<>();

        for(int i=0; i<N; i++){
            char ch = A.charAt(i);
            if(st.isEmpty() || st.peek() != ch){
                st.push(ch);
            }else{
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}