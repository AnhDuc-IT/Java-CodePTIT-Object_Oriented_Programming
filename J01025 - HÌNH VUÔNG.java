import java.util.*;

public class Solution {
    public static int MOD = 1000000007;
    public static void change(String s){
        boolean check = true;
        char[] a = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(a[i] != '0' && a[i] != '1' && a[i] != '8' && a[i] != '9'){
                System.out.println("INVALID");
                return;
            }
            if(a[i] == '8') a[i] = '0';
            if(a[i] == '9') a[i] = '0';
        }
        for(char x : a){
            if(x != '0') check = false;
        }
        if(check){
            System.out.println("INVALID");
            return;
        }
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(a[i] != '0'){
                pos = i;
                break;
            }
        }
        for(int i = pos; i < s.length(); i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

        int e = sc.nextInt(), g = sc.nextInt(), h = sc.nextInt(), j = sc.nextInt();
        int x1 = Math.min(a, e), x2 = Math.max(c, h);
        int y1 = Math.min(b, g), y2 = Math.max(d, j);
        int ans = Math.max((y2 - y1), (x2 - x1));
        System.out.println(ans * ans);
    }
}
