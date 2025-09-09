import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Subject{
    private String ID, name;
    private int quantity;
    public Subject(String ID, String name, int quantity){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
}
class Student{
    private String code, nameSV, lop, email;
    public Student(String code, String nameSV, String lop, String email){
        this.code = code;
        this.nameSV = nameSV;
        this.lop = lop;
        this.email = email;
    }
    public String getCode(){
        return this.code;
    }
    public String getNameSV(){
        return this.nameSV;
    }
    public String getLop(){
        return this.lop;
    }
    public void setName(){
        String[] a = this.nameSV.trim().split("\\s+");
        String res = "";
        for(String x : a){
            res += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length(); i++){
                res += Character.toLowerCase(x.charAt(i));
            }
            res += " ";
        }
        this.nameSV = res.trim();
    }
}
class BoardScore implements Comparable <BoardScore>{
    private Subject subject;
    private Student student;
    private String Score;
    public BoardScore(String Score, Subject subject, Student student){
        this.Score = Score;
        this.subject = subject;
        this.student = student;
    }
    public Subject getSubject(){
        return this.subject;
    }
    public Student getStudent(){
        return this.student;
    }
    public String getScore(){
        return this.Score;
    }
    public String toString(){
        this.student.setName();
        return this.student.getCode() + " " + this.student.getNameSV() + " " + this.subject.getID() + " " + this.subject.getName() + " " + this.getScore();
    }
    public int compareTo(BoardScore other){
        if(this.subject.getID().equals(other.subject.getID())){
            return this.subject.getID().compareTo(other.subject.getID());
        }
        return this.subject.getID().compareTo(other.subject.getID());
    }
}
public class Solution{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("SINHVIEN.in"));
        int n = Integer.parseInt(br1.readLine());
        Map <String, Student> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            Student a = new Student(br1.readLine(), br1.readLine(), br1.readLine(), br1.readLine());
            map.put(a.getCode(), a);
        }
        br1.close();
        Map <String, Subject> mp = new HashMap<>();
        BufferedReader br2 = new BufferedReader(new FileReader("MONHOC.in"));
        int m = Integer.parseInt(br2.readLine());
        for(int i = 1; i <= m ;i++){
            Subject a = new Subject(br2.readLine(), br2.readLine(), Integer.parseInt(br2.readLine()));
            mp.put(a.getID(), a);
        }
        br2.close();
        BufferedReader br3 = new BufferedReader(new FileReader("BANGDIEM.in"));
        int p = Integer.parseInt(br3.readLine());
        ArrayList <BoardScore> arr = new ArrayList<>();
        for(int i = 1; i <= p; i++){
            String[] a = br3.readLine().split("\\s+", 3);
            BoardScore temp = new BoardScore(a[2], mp.get(a[1]), map.get(a[0]));
            arr.add(temp);
        }
        Collections.sort(arr);
        int q = Integer.parseInt(br3.readLine());
        while(q-- >0){
            String s = br3.readLine();
            System.out.println("BANG DIEM lop " + s + ":");
            for(BoardScore x : arr){
                if(x.getStudent().getLop().equals(s)){
                    System.out.println(x);
                }
            }
        }
        br3.close();
    }
}
