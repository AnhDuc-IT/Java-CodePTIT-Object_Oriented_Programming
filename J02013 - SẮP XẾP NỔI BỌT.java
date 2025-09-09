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
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int buoc = 1;
        for(int i = 0; i < n - 1; i++){
            boolean check = true;
            for(int j = 0; j < n - 1; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    check = false;
                }
            }
            if(!check){
                System.out.print("Buoc " + buoc + ": ");
                for(int j = 0; j < n; j++){
                    System.out.print(a[j] + " ");
                }
                ++buoc;
                System.out.println();
            }
        }
    }
}
