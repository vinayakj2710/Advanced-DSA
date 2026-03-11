import java.util.*;

public class BalancedParanthesis{
    public static void main(String args[]){
        System.out.println("Balanced Paranthesis");

        String str = "{[()]}";
        System.out.println("Balanced Parenthesis: " + balancedParanthesis(str));
    }

    public static boolean balancedParanthesis(String A){
        Stack<Character> st = new Stack<>();
        int N = A.length();
        
        for(int i=0; i<N; i++){
            char ch = A.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.size() == 0) return false;
                if(ch == ')' && st.peek() == '(' || ch == '}' && st.peek() == '{' || ch == ']' && st.peek() == '['){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.size() > 0) return false;
        return true;
    }
}