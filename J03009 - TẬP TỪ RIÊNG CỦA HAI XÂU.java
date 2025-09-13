import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String a = sc.nextLine();
            String b = sc.nextLine();
            Set<String> set = new HashSet<>();
            String[] x = a.split(" ");
            String[] y = b.split(" ");
            for(int i = 0; i < y.length; i++){
                set.add(y[i]);
            }
            Set <String> res = new HashSet<>();
            for(int i = 0; i < x.length; i++){
                if(!set.contains(x[i])){
                    res.add(x[i]);
                }
            }
            for(String it : res){
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
