import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
class Employee{
    private String ID, name, birth;
    private double theory, practie;
    public Employee(int ID, String name, String birth, double theory, double practice){
        this.ID = "PH" + String.format("%02d", ID);
        this.name = name;
        this.birth = birth;
        this.theory = theory;
        this.practie = practice;
    }
    public double getPrize(){
        if(this.theory >= 8 && this.practie >= 8){
            return 1;
        }else if(this.theory >= 7.5 && this.practie >= 7.5) return 0.5;
        return 0;
    }
    public int getScore(){
        double res = (this.theory + this.practie) / 2.0 + this.getPrize();
        if(res >= 10) return 10;
        return (int)Math.round(res);
    }
    public int getOld(){
        String[] a = this.birth.split("/");
        return 2021 - Integer.parseInt(a[2]);
    }
    public String getRanking(){
        if(this.getScore() == 9 || this.getScore() == 10) return "Xuat sac";
        else if(this.getScore() == 8) return "Gioi";
        else if(this.getScore() == 7) return "Kha";
        else if(this.getScore() >= 5 && this.getScore() <= 6) return "Trung binh";
        return "Truot";
    }
    public String toString(){
        String[] a = this.name.trim().split("\\s+");
        String res = "";
        for(String x : a){
            res += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length() ;i++){
                res += Character.toLowerCase(x.charAt(i));
            }
            res += " ";
        }
        this.name = res.trim();
        return this.ID + " " + this.name + " " + this.getOld() + " " + (int)Math.round(this.getScore()) + " " + this.getRanking();
    }
}
public class Solution {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("XETTUYEN.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Employee> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Employee a = new Employee(i, br.readLine(), br.readLine(), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()));
                arr.add(a);
            }
            for(Employee x : arr){
                System.out.println(x);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
