import java.util.*;
import java.math.BigInteger;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int temp = s;
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = n - 1; i >= 0; i--){
            if(s > 9){
                a[i] = 9;
                s -= 9;
            }else{
                if(i == 0){
                    a[i] = s;
                    break;
                }else{
                    if(s == 1){
                        a[0] = 1;
                        a[i] = 0;
                        s = 0;
                        break;
                    }else{
                        a[0] = 1;
                        a[i] = s - 1;
                        s = 0;
                        break;
                    }
                }
            }
        }
        s = temp;
        for(int i = 0; i < n; i++){
            if(s >= 9){
                b[i] = 9;
                s -= 9;
            }
            else{
                b[i] = s;
                s = 0;
                break;
            }
        }
        if(9 * n < temp || n > 1 && temp == 0){
            System.out.print("-1 -1");
        }else{
            for(int i = 0; i < n; i++){
                System.out.print(a[i]);
            }
            System.out.print(" ");
            for(int i = 0; i < n; i++){
                System.out.print(b[i]);
            }
        }
    }
}
