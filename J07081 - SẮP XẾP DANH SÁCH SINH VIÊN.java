import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
class Student implements Comparable <Student>{
    private String ID, name, phone, email;
    public Student(String ID, String name, String phone, String email){
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    //mai anh mot duc
    public String getName(){
        String[] a = this.name.trim().split("\\s+");
        String ten = "";
        ten += a[a.length - 1];
        ten += a[0];
        for(int i = 1; i < a.length - 1; i++){
            ten += a[i];
        }
        return ten;
    }
    @Override
    public int compareTo(Student other){
        if(this.getName().equals(other.getName())){
            return this.ID.compareTo(other.ID);
        }
        return this.getName().compareTo(other.getName());
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.phone + " " + this.email;
    }
}
public class Solution {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("SINHVIEN.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Student> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Student a = new Student(br.readLine(), br.readLine(), br.readLine(), br.readLine());
                arr.add(a);
            }
            Collections.sort(arr);
            for(Student x : arr){
                System.out.println(x);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
