import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException.*;
import java.lang.reflect.Array;
class Student{
    private String ID, name, phone;
    public Student(String ID, String name, String phone){
        this.ID = ID;
        this.name = name;
        this.phone = phone;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
}
class HomeWork{
    private String code;
    public HomeWork(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
}
class Group implements Comparable <Group>{
    private int quantity;
    private Student student;
    private HomeWork homeWork;
    public Group(int quantity, Student student, HomeWork homeWork){
        this.quantity = quantity;
        this.student = student;
        this.homeWork = homeWork;
    }
    public String toString(){
        return this.student.getID() + " " + this.student.getName() + " " + this.student.getPhone() + " " + this.quantity + " " + this.homeWork.getCode();
    }
    @Override
    public int compareTo(Group other){
        return this.student.getID().compareTo(other.student.getID());
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("SINHVIEN.in"));
            BufferedReader br2 = new BufferedReader(new FileReader("BAITAP.in"));
            BufferedReader br3 = new BufferedReader(new FileReader("NHOM.in"));
            Map <String, Student> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int i = 1; i <= n; i++){
                Student a = new Student(br.readLine(), br.readLine(), br.readLine());
                map.put(a.getID(), a);
            }
            int m = Integer.parseInt(br2.readLine());
            LinkedHashMap <Integer, HomeWork> mp = new LinkedHashMap<>();
            for(int i = 1; i <= m; i++){
                String temp = br2.readLine();
                mp.put(i, new HomeWork(temp));
            }
            ArrayList <Group> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                String[] a = br3.readLine().split("\\s+");
                Group temp = new Group(Integer.parseInt(a[1]), map.get(a[0]), mp.get(Integer.parseInt(a[1])));
                arr.add(temp);
            }
            Collections.sort(arr);
            for(Group x : arr){
                System.out.println(x);
            }
            br.close();
            br2.close();
            br3.close();
        } catch (Exception e) {
        }
    }
}
