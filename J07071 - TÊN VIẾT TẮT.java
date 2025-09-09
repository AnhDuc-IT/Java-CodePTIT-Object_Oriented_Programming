import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Person implements Comparable<Person>{
    private String name;
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        String[] a = this.name.split("\\s+");
        String res = "";
        for(int i = 0; i < a.length; i++){
            res += Character.toUpperCase(a[i].charAt(0));
            if(i < a.length - 1){
                res += ".";
            }
        }
        return res;
    }
    public String toString(){
        return this.name;
    }
    public String Convert(){
        String[] a = this.name.split(" ");
        String res = "";
        res += a[a.length - 1] + a[0];
        for(int i = 1; i < a.length - 1; i++){
            res += a[i];
        }
        return res;
    }
    @Override
    public int compareTo(Person other){
        return this.Convert().compareTo(other.Convert());
    }
}
public class Solution{
    static String Change(String s){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                res += s.charAt(i);
            }
        }
        return res;
    }
    static boolean check(String a, String b){
        if(a.length() != b.length()) return false;
        boolean ok = false;
        for(int i = 0; i < a.length();i++){
            char temp = b.charAt(i);
            if(temp == '*'){
                if(ok) return false;
                ok = true;
                continue;
            }
            if(a.charAt(i) != temp) return false;
        }
        return true;
    }
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("DANHSACH.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Person> arr = new ArrayList<>();
            for(int i = 1; i <= n ;i++){
                Person a = new Person(br.readLine());
                arr.add(a);
            }
            int q = Integer.parseInt(br.readLine());
            Collections.sort(arr);
            for(int i = 1; i <= q; i++){
                String s = br.readLine().trim();
                for(Person x : arr){
                    if(check(x.getName(), s)){
                        System.out.println(x);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
