import java.util.*;
public class Solution{
    public static boolean check(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            ++l; --r;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Map <String,Integer> map = new HashMap<>();
        String ans = "";
        ArrayList <String> arr = new ArrayList<>();
        while(sc.hasNext()){
            String line = sc.next();
            if(line.isEmpty()) continue;
            if(line.length() > ans.length() && check(line)){
                ans = line;
            }
            if(map.containsKey(line)){
                map.put(line, map.get(line) + 1);
            }else{
                map.put(line, 1);
            }
            arr.add(line);
        }
        for(String x : arr){
            if(x.length() == ans.length() && map.get(x) != 0 && check(x)){
                System.out.println(x + " " + map.get(x));
                map.put(x, 0);
            }
        }
    }
}
