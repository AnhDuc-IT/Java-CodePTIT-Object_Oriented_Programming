import java.util.*;

public class Solution {
    public static String Process(String s) {
        StringBuilder sb = new StringBuilder();
        char maxChar = 'a';
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c >= maxChar) {
                sb.append(c);
                maxChar = c;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(Process(s));
    }
}
