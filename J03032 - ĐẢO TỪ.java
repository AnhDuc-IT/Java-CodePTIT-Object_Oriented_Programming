import java.util.*;

public class Solution {
    public static String change(String s){
        String res = "";
        for(int i = s.length() - 1; i >= 0; i--){
            res += s.charAt(i);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            String[] a = s.split(" ");
            for(int i = 0; i < a.length; i++){
                System.out.print(change(a[i]) + " ");
            }
            System.out.println();
        }
    }
}
