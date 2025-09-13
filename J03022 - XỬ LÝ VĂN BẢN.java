import java.io.*;
import java.util.*;

public class Solution {
    static String change(String s){
        String res = "";
        res += Character.toUpperCase(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            res += Character.toLowerCase(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();

        while(sc.hasNextLine()){
            String line = sc.nextLine().trim();
            if(line.isEmpty()) continue;
            String[] a = line.split("\\s+");
            for(String x : a){
                arr.add(x);
            }
        }

        boolean check = true;
        StringBuilder sb = new StringBuilder();
        for(String x : arr){
            char temp = x.charAt(x.length() - 1);
            boolean end = (temp == '.' || temp == '!' || temp == '?');
            String word = end ? x.substring(0, x.length() - 1) : x;
            if(check){
                if(!word.isEmpty()){
                    sb.append(change(word));
                }
                check = false;
            }else{
                if(!word.isEmpty()){
                    sb.append(" ").append(word.toLowerCase());
                }
            }
            if(end){
                System.out.println(sb.toString().trim());
                sb.setLength(0);
                check = true;
            }
        }
        if(sb.length() > 0){
            System.out.println(sb.toString().trim());
        }
    }
}
