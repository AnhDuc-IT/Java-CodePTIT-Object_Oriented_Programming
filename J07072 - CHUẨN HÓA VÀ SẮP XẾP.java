import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections; 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("DANHSACH.in"));
        ArrayList <String> arr = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            String[] a = line.trim().split("\\s+");
            String res = "";
            for(String x : a){
                res += Character.toUpperCase(x.charAt(0));
                for(int i = 1; i < x.length(); i++){
                    res += Character.toLowerCase(x.charAt(i));
                }
                res += " ";
            }
             arr.add(res);
        }
        Collections.sort(arr, new Comparator<String>(){
            public int compare(String o1, String o2){
                String[] a = o1.split(" ");
                String[] b = o2.split(" ");
                String temp = "";
                for(int i = 1; i < a.length - 1; i++){
                    temp += a[i];
                }
                String tmp = "";
                for(int i = 1; i < b.length - 1; i++){
                    tmp += b[i];
                }
                if(a[a.length - 1].compareTo(b[b.length - 1]) == 0){
                    if(a[0].compareTo(b[0]) == 0){
                        return temp.compareTo(tmp);
                    }else{
                        return a[0].compareTo(b[0]);
                    }
                }
                return a[a.length - 1].compareTo(b[b.length - 1]);
            }
        });
        for(String x : arr){
            System.out.println(x);
        }
    }
}
