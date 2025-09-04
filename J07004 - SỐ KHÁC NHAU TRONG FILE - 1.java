import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.*;
public class Solution {
    public static boolean check(String s){
        if(s == null || s.isEmpty()) return false;
        if(s.length() > 10) return false;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("DATA.in"));
            TreeMap <Integer, Integer> map = new TreeMap<>();
            while(sc.hasNext()){
                Integer temp = Integer.parseInt(sc.next());
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                }else{
                    map.put(temp, 1);
                }
            }
            Set <Map.Entry<Integer, Integer>> entrySet = map.entrySet();
            for(Map.Entry<Integer, Integer> entry : entrySet){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            sc.close();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}
