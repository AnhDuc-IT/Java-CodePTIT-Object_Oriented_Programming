import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
                a[i] = 1l * a[i] * a[i];
            }
            Arrays.sort(a);
            boolean check = true;
            for(int i = n - 1; i >= 2; i--){
                int l = 0, r = i - 1;
                while(l < r){
                    if(a[l] + a[r] == a[i]){
                        check = false;
                        break;
                    } else if(a[l] + a[r] < a[i]){
                        ++l;
                    } else{
                        --r;
                    }
                    if(!check){
                        break;
                    }
                }
            }
            System.out.println(!check ? "YES" : "NO");
        }
    }
}
