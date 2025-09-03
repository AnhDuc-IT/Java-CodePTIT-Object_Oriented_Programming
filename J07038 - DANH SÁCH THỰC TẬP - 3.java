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
}
class Business{
    private String code, namee;
    private int quantity;
    public Business(String code, String name, int quantity){
        this.code = code;
        this.namee = name;
        this.quantity = quantity;
    }
    public String getCode(){
        return this.code;
    }
    public String getNamee(){
        return this.namee;
    }
    public int getQuantity(){
        return this.quantity;
    }
}
class Information implements Comparable <Information>{
    private Student student;
    private Business business;
    public Information(Student student, Business business){
        this.student = student;
        this.business = business;
    }
    public Student getStudent(){
        return this.student;
    }
    public Business getBusiness(){
        return this.business;
    }
    public String toString(){
        return this.student.getID() + " " + this.student.getName() + " " + this.student.getLop();
    }
    @Override
    public int compareTo(Information other){
        return this.student.getID().compareTo(other.student.getID());
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("SINHVIEN.in"));
            BufferedReader br2 = new BufferedReader(new FileReader("DN.in"));
            BufferedReader br3 = new BufferedReader(new FileReader("THUCTAP.in"));
            int n = Integer.parseInt(br.readLine());
            Map <String, Student> map = new HashMap<>();
            for(int i = 1; i <= n ;i++){
                Student a = new Student(br.readLine(), br.readLine(), br.readLine(), br.readLine());
                map.put(a.getID(), a);
            }
            int m = Integer.parseInt(br2.readLine());
            Map <String, Business> mp = new HashMap<>();
            for(int i = 1; i <= m; i++){
                Business a = new Business(br2.readLine(), br2.readLine(), Integer.parseInt(br2.readLine()));
                mp.put(a.getCode(), a);
            }
            int p = Integer.parseInt(br3.readLine());
            ArrayList <Information> arr = new ArrayList<>();
            for(int i = 1; i <= p; i++){
                String[] a = br3.readLine().split(" ");
                Information temp = new Information(map.get(a[0]), mp.get(a[1]));
                arr.add(temp);
            }
            Collections.sort(arr);
            int Q = Integer.parseInt(br3.readLine());
            for(int i = 1; i <= Q; i++){
                int cnt = 1;
                String s = br3.readLine();
                int ans = mp.get(s).getQuantity();
                System.out.println("DANH SACH THUC TAP TAI " + mp.get(s).getNamee() + ":");
                for(Information x : arr){
                    if(x.getBusiness().getCode().equals(s) && cnt <= ans){
                        System.out.println(x);
                        ++cnt;
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
