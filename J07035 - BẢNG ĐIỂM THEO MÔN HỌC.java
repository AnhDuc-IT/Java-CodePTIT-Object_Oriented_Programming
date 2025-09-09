import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException.*;
import java.lang.reflect.Array;
class Student{
    private String ID, name, lop, email;
    public Student(String ID, String name, String lop, String email){
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.email = email;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        String[] a = this.name.trim().split("\\s+");
        String res = "";
        for(String x : a){
            res += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length(); i++){
                res += Character.toLowerCase(x.charAt(i));
            }
            res += " ";
        }
        this.name = res.trim();
        return this.name;
    }
    public String getLop(){
        return this.lop;
    }
    public String getEmail(){
        return this.email;
    }
}
class Subject{
    private String code, Name;
    private int quantity;
    public Subject(String code, String name, int quantity){
        this.code = code;
        this.Name = name;
        this.quantity = quantity;
    }
    public String getCode(){
        return this.code;
    }
    public String getTen(){
        return this.Name;
    }
}
class Score implements Comparable <Score>{
    private String score;
    private Student student;
    private Subject subject;
    public Score(String score, Student student, Subject subject){
        this.score = score;
        this.student = student;
        this.subject = subject;
    }
    public Subject getSubject(){
        return this.subject;
    }
    public String toString(){
            return this.student.getID() + " " + this.student.getName() + " " + this.student.getLop() + " " + this.score;
    }
    @Override
    public int compareTo(Score other){
        double temp = Double.parseDouble(this.score);
        double tmp = Double.parseDouble(other.score);
        if(temp == tmp){
            return this.student.getID().compareTo(other.student.getID());
        }else{
            if(temp > tmp) return -1;
            return 1;
        }
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("SINHVIEN.in"));
            BufferedReader br2 = new BufferedReader(new FileReader("MONHOC.in"));
            BufferedReader br3 = new BufferedReader(new FileReader("BANGDIEM.in"));
            int n = Integer.parseInt(br.readLine());
            Map <String, Student> map = new HashMap<>();
            for(int i = 1; i <= n; i++){
                Student a = new Student(br.readLine(), br.readLine(), br.readLine(), br.readLine());
                map.put(a.getID(), a);
            }
            int m = Integer.parseInt(br2.readLine());
            Map <String, Subject> mp = new HashMap<>();
            for(int i = 1; i <= m; i++){
                Subject a = new Subject(br2.readLine(), br2.readLine(), Integer.parseInt(br2.readLine()));
                mp.put(a.getCode(), a);
            }
            int q = Integer.parseInt(br3.readLine());
            ArrayList <Score> arr = new ArrayList<>();
            for(int i = 1; i <= q; i++){
                String[] a = br3.readLine().split("\\s+");
                Score temp = new Score(a[2], map.get(a[0]), mp.get(a[1]));
                arr.add(temp);
            }
            Collections.sort(arr);
            int Q = Integer.parseInt(br3.readLine());
            for(int i = 1; i <= Q; i++){
                String line = br3.readLine();
                System.out.println("BANG DIEM MON " + mp.get(line).getTen()+ ":");
                for(Score x : arr){
                    if(x.getSubject().getCode().equals(line)){
                        System.out.println(x);
                    }
                }
            }
            br.close();
            br2.close();
            br3.close();
        } catch (Exception e) {
        }
    }
}
