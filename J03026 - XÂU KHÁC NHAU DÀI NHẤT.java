
import java.util.*;
public class Solution{
    public static int Process(String a, String b){
        int n = a.length(), m = b.length();
        int max_ans = -1;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                String temp = a.substring(i, j + 1);
                if(b.contains(temp) == false){
                    max_ans = Math.max(max_ans, temp.length());
                }
            }
        }
        for(int i = 0; i < m - 1; i++){
            for(int j = i + 1; j < m; j++){
                String temp = b.substring(i, j + 1);
                if(a.contains(temp) == false){
                    max_ans = Math.max(max_ans, temp.length());
                }
            }
        }
        return max_ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.next();
        while(t -- > 0){
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(Process(a, b));
        }
    }
}
