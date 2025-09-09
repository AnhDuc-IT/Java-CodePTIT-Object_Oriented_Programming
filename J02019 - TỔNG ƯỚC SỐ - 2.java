import java.io.*;
import java.util.*;
public class Solution {
    static final int MAX = 1000000;
    static long[] nt = new long[MAX + 1];
    public static void sieve(){
        for(int i = 1; i <= MAX; i++){
            for(int j = i * 2; j <= MAX; j += i){
                nt[j] += i;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), r = sc.nextInt();
        sieve();
        long cnt = 0;
        for(int i = l; i <= r; i++){
            if(nt[i] > i) ++cnt;
        }
        System.out.println(cnt);
    }
}
