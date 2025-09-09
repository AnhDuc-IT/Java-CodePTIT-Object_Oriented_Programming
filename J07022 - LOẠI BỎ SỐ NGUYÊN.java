import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Solution{
    public static boolean check(String s){
        if(s == null || s.isEmpty()) return false;
        if(s.length() > 10) return false;
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            File file = new File("DATA.in");
            Scanner sc = new Scanner(file);
            ArrayList <String> set = new ArrayList<>();
            while(sc.hasNext()){
                String s = sc.next();
                if(!check(s)){
                    set.add(s);
                }
            }
            Collections.sort(set, new Comparator<String>(){
                @Override
                public int compare(String o1, String o2){
                    return o1.compareTo(o2);
                }
            });
            for(String x : set){
                System.out.print(x + " ");
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
