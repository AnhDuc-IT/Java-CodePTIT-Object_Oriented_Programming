import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Student{
    private String ID, name, lop, birth;
    private double GPA;
    public Student(int ID, String name, String lop, String birth, double GPA){
        this.ID = "B20DCCN" + String.format("%03d", ID);
        this.name = name;
        this.lop = lop;
        this.birth = birth;
        this.GPA = GPA;
    }
    public void setName(){
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
    }
    public void setBirth(){
        StringBuilder sb = new StringBuilder(this.birth);
        if(sb.charAt(2) != '/') sb.insert(0, "0");
        if(sb.charAt(5) != '/') sb.insert(3, "0");
        this.birth = sb.toString();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.lop + " " + this.birth + " " + String.format("%.2f", this.GPA);
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student x = new Student(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
            x.setBirth();
            x.setName();
            arr.add(x);
        }
        for(Student x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
