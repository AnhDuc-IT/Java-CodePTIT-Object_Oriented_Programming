import java.io.*;
import java.util.*;

public class Solution {
    static int pre(char x){
        if(x == 'I') return 1;
        else if(x == 'V') return 5;
        else if(x == 'X') return 10;
        else if(x == 'L') return 50;
        else if(x == 'C') return 100;
        else if(x == 'D') return 500;
        return 1000;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- > 0){
            String s = sc.next();
            int ans = 0;
            for(int i = 0; i < s.length(); i++){
                int value = pre(s.charAt(i));
                if(i + 1 < s.length() && value < pre(s.charAt(i + 1))){
                    ans -= value;
                }else{
                    ans += value;
                }
            }
            System.out.println(ans);
        }
    }
}
