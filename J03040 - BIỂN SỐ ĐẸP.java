import java.util.*;
public class Solution {
    public static boolean check1(String s){
       char[] a = s.toCharArray();
       int n = s.length();
       if(a[n - 1] <= a[n - 2]) return false;
       for(int i = 6; i <= 7; i++){
        if(a[i] <= a[i - 1]) return false;
       }
       return true;
    }
    public static boolean check2(String s){
        char[] a = s.toCharArray();
        int n = s.length();
        if(a[n - 1] != a[n - 2]) return false;
        for(int i = 6; i <= 7; i++){
            if(a[i] != a[i - 1]) return false;
        }
        return true;
    }
    public static boolean check3(String s){
        char[] a = s.toCharArray();
        int n = s.length();
        if(a[n - 1] != a[n - 2]) return false;
        for(int i = 6; i <= 7; i++){
            if(a[i] != a[i - 1] && a[i] != a[n - 1]) return false;
        }
        return true;
    }
    public static boolean check4(String s){
        char[] a = s.toCharArray();
        int n = s.length();
        for(int i = 5; i <= n - 1; i++){
            if(i != 8){
                if(a[i] != '8' && a[i] != '6') return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            if(check1(s) || check2(s) || check3(s) || check4(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
