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
            String[] arr = s.trim().split("\\s+");
            for(int i = 1; i < arr.length; i++){
                System.out.print(change(arr[i]));
                if(i != arr.length - 1){
                    System.out.print(" ");
                }else{
                    System.out.print(", ");
                }
            }
            System.out.println(arr[0].toUpperCase());
        }
    }
}
