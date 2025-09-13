import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack <Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(st.empty()){
                st.push(s.charAt(i));
            }else{
                if(st.lastElement() == s.charAt(i)){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        if(st.empty()){
            System.out.println("Empty String");
        }else{
            st.forEach((x) -> System.out.print(x));
        }
        sc.close();
    }
}
