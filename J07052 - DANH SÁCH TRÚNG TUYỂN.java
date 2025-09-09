import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException.*;
class Student implements Comparable <Student>{
    private String ID, name;
    private double sc1, sc2, sc3;
    public Student(String ID, String name, double sc1, double sc2, double sc3){
        this.ID = ID;
        this.name = name;
        this.sc1 = sc1;
        this.sc2 = sc2;
        this.sc3 = sc3;
    }
    public double getPriority(){
        if(this.ID.charAt(2) == '1') return 0.5;
        else if(this.ID.charAt(2) == '2') return 1;
        return 2.5;
    }
    public double getScore(){
        return 2.0 * this.sc1 + this.sc2 + this.sc3 + this.getPriority();
    }
    public String toString(){
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
        if(this.getPriority() == (int)this.getPriority()){
            if(this.getScore() == (int)this.getScore()){
                return this.ID + " " + this.name + " " + (int)this.getPriority() + " " + String.format("%.0f", this.getScore());
            }else{
                return this.ID + " " + this.name + " " + (int)this.getPriority() + " " + String.format(("%.1f"), this.getScore());
            }
        }else{
            if(this.getScore() == (int)this.getScore()){
                return this.ID + " " + this.name + " " + String.format("%.1f", this.getPriority()) + " " + (int)this.getScore();
            }else{
                return this.ID + " " + this.name + " " + String.format("%.1f", this.getPriority()) + " " + String.format("%.1f", this.getScore());
            }
        }
    }
    public int compareTo(Student other){
        if(this.getScore() > other.getScore()) return -1;
        return 1;
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("THISINH.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Student> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Student a = new Student(br.readLine(), br.readLine(), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()));
                arr.add(a);
            }
            Collections.sort(arr);
            int cnt = 0;
            double ans = 0;
            int q = Integer.parseInt(br.readLine());
            for(Student x : arr){
                ++cnt;
                if(cnt == q){
                    ans = x.getScore();
                }
            }
            System.out.println(ans);
            for(int i = 0; i < n; i++){
                if(arr.get(i).getScore() >= ans){
                    System.out.println(arr.get(i) + " TRUNG TUYEN");
                }else{
                    System.out.println(arr.get(i) + " TRUOT");
                }
            }
            br.close();
        } catch (Exception e) {
        }
    }
}
