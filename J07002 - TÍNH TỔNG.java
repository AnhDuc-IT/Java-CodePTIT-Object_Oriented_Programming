import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            long total = 0;
            while(sc.hasNext()){
                String t = sc.next();
                if(check(t)){
                    total += Integer.parseInt(t);
                }
            }
            System.out.println(total);
            sc.close();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}
