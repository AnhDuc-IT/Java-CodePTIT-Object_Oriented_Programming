import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap <String, Integer> map = new HashMap<>();
        int t = sc.nextInt();
        sc.nextLine();
        String[] cnt = new String[1005];
        while(t-- > 0){
            String s = sc.nextLine();
            String[] a = s.trim().split("\\s+");
            String res = "";
            res += a[a.length - 1].toLowerCase();
            for(int i = 0; i < a.length - 1; i++){
                res += Character.toLowerCase(a[i].charAt(0));
            }
            String temp = res;
            temp += "@ptit.edu.vn";
            if(map.containsKey(temp)){
                int ans = map.get(temp);
                res += (char)(ans + '0' + 1);
                map.put(temp, map.get(temp) + 1);
            }else{
                map.put(temp, 1);
            }
            res += "@ptit.edu.vn";
            System.out.println(res);
        }
    }
}
