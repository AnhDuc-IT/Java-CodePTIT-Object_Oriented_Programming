import java.io.*;
import java.util.*;

public class Solution {
    static char change(char c){
        if('A' <= c && c <= 'C') return '2';
        else if('D' <= c && c <= 'F') return '3';
        else if('G' <= c && c <= 'I') return '4';
        else if('J' <= c && c <= 'L') return '5';
        else if('M' <= c && c <= 'O') return '6';
        else if('P' <= c && c <= 'S') return '7';
        else if('T' <= c && c <= 'V') return '8';
        return '9';
    }
    static boolean check(String s){
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
    static String Convert(String s){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            res += Character.toUpperCase(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        while(n-- > 0){
            String s = sc.nextLine();
            s = Convert(s);
            String res = "";
            for(int i = 0; i < s.length(); i++){
                res += change(s.charAt(i));
            }
            if(check(res)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
