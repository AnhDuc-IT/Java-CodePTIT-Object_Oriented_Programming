import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.*;
class Student{
    private String ID, name, lop, birth;
    private double GPA;
    public Student(int ID, String name, String lop, String birht, double GPA){
        this.ID = "B20DCCN" + String.format("%03d", ID);
        this.name = name;
        this.lop = lop;
        this.birth = birht;
        this.GPA = GPA;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder(this.birth);
        if(sb.charAt(2) != '/') sb.insert(0, "0");
        if(sb.charAt(5) != '/') sb.insert(3, "0");
        this.birth = sb.toString();
        return this.ID + " " + this.name + " " + this.lop + " " + this.birth + " " + String.format("%.2f", this.GPA);
    }
}
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
            Scanner sc = new Scanner(new File("SV.in"));
            ArrayList <Student> arr = new ArrayList<>();
            int n = sc.nextInt();
            for(int i = 1; i <= n ;i++){
                sc.nextLine();
                Student a = new Student(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
                arr.add(a);
            }
            for(Student x : arr){
                System.out.println(x);
            }
            sc.close();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}
