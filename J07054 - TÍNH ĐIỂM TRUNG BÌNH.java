import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
class Student{
    private String ID, name;
    private double sc1, sc2, sc3;
    private int stt;
    public Student(int ID, String name, double sc1, double sc2, double sc3){
        this.ID = "SV" + String.format("%02d", ID);
        this.name = name;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
    }
    public void setSTT(int cnt){
        this.stt = cnt;
    }
    public String getID(){
        return this.ID;
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
    public double getGPA(){
        return (3.0 * this.sc1 + 3.0 * this.sc2 + 2.0 * this.sc3) / 8.0;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + String.format("%.2f", this.getGPA()) + " " + this.stt;
    }
}
public class Solution {
    private static BufferedReader BufferedReader;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("BANGDIEM.in"));
        int n = Integer.parseInt(br.readLine());
        ArrayList <Student> arr = new ArrayList<>();
        ArrayList <Student> a = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Student x = new Student(i, br.readLine(), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()));
            x.setName();
            arr.add(x);
            a.add(x);
        }
        Collections.sort(a, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.getGPA() == o2.getGPA()) return o1.getID().compareTo(o2.getID());
                else{
                    if(o1.getGPA() > o2.getGPA()) return -1;
                    return 1;
                }
            }
        });
        Map <Double, Integer> map = new HashMap<>();
        int cnt = 1;
        for(Student x : a){
            map.putIfAbsent(x.getGPA(), cnt);
            x.setSTT(map.get(x.getGPA()));
            ++cnt;
        }
        for(Student x : a){
            System.out.println(x);
        }
        br.close();
    }
}
