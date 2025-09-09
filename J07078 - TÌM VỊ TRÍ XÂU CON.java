import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class Solution {
    static void solve(String a, String b){
        ArrayList <Integer> arr = new ArrayList<>();
        int n = a.length(), m = b.length();
        for(int i = 0; i <= n - m; i++){
            String temp = a.substring(i, i + m);
            if(temp.equals(b)){
                arr.add(i + 1);
            }
        }
        for(int x : arr){
            System.out.print(x + " ");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("STRING.in"));
        int n = sc.nextInt();
        while(n-- > 0){
            String a = sc.next();
            String b = sc.next();
            solve(a, b);
            System.out.println();
        }
        sc.close();
    }
}
