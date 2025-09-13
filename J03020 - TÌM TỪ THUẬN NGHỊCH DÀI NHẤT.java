import java.util.*;
public class Solution {
    public static boolean check(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder all = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            all.append(line).append(" ");
        }
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(all.toString());
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int maxLen = 0;
        for(String key : map.keySet()){
            if(check(key)){
                maxLen = Math.max(maxLen, key.length());
            }
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getKey().length() == maxLen && check(entry.getKey())){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
