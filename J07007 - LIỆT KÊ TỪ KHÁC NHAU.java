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
            Scanner sc = new Scanner(new File("VANBAN.in"));
            TreeSet <String> set = new TreeSet<>();
            while(sc.hasNext()){
                set.add(sc.next().toLowerCase());
            }
            for(String x : set){
                System.out.println(x);
            }
            sc.close();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}
