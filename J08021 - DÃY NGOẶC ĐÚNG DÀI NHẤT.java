import java.util.*;

public class Solution {
    static int solve(String s){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for(int i = 0; i < s.length();i++){
            char x = s.charAt(i);
            if(x == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res, i - stack.lastElement());
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            System.out.println(solve(s));
        }
    }
}
