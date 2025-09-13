import java.util.*;

public class Solution {
    public static String change(String s){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            if(i == 0){
                res += Character.toUpperCase(s.charAt(i));
            }else{
                res += Character.toLowerCase(s.charAt(i));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s = sc.nextLine();
            String[] a = s.split("\\s+");
            for(int i = 0; i < a.length; i++){
                System.out.print(change(a[i]) + " ");
            }
            System.out.println();
        }
    }
}
