import java.awt.*;
import java.util.*;


public class Solution {
    static boolean check(String s){
        Stack <Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x == '{' || x == '(' || x == '['){
                stack.push(x);
            }else{
                if(!stack.isEmpty()){
                    char y = stack.lastElement();
                    if((y == '{' && x != '}') || (y == '[' && x != ']') || (y == '(' && x != ')')) return false;
                    else{
                        stack.pop();
                    }
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            if(check(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
