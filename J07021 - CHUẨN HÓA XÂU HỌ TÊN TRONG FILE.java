import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        try {
            Scanner sc  = new Scanner(new File("DATA.in"));
            ArrayList <String> arr = new ArrayList<>();
            while(sc.hasNextLine()){
                String s = sc.nextLine().trim();
                if(s.equals("END")) break;
                String[] a = s.split("\\s+");
                String res = "";
                for(String x : a){
                    res += Character.toUpperCase(x.charAt(0));
                    for(int i = 1; i < x.length(); i++){
                        res += Character.toLowerCase(x.charAt(i));
                    }
                    res += " ";
                }
                arr.add(res.trim());
            }
            for(String x : arr){
                System.out.println(x);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
