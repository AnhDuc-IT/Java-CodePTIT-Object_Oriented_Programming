import java.util.*;
class newEmployee implements Comparable<newEmployee>{
    private String ID, name;
    private double theory, practice;
    public newEmployee(int ID, String name, double theory, double practice){
        this.ID = "TS" + String.format("%02d", ID);
        this.name = name;
        this.theory = theory;
        this.practice = practice;
    }
    public double getScore(){
        if(this.theory > 10){
            this.theory = this.theory / 10.0;
        }
        if(this.practice > 10){
            this.practice = this.practice / 10.0;
        }
        return (this.theory + this.practice) / 2.0;
    }
    public String getResult(){
        if(this.getScore() > 9.5) return "XUAT SAC";
        else if(this.getScore() >= 8) return "DAT";
        else if(this.getScore() > 5) return "CAN NHAC";
        return "TRUOT";
    }
    public String toString(){
        return this.ID + " " + this.name + " " + String.format("%.2f", getScore()) + " " + this.getResult();
    }
    @Override
    public int compareTo(newEmployee other){
        if(this.getScore() > other.getScore()) return -1;
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <newEmployee> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            newEmployee a = new newEmployee(i, sc.nextLine(), sc.nextDouble(), sc.nextDouble());
            arr.add(a);
        }
        Collections.sort(arr);
        for(newEmployee x : arr){
            System.out.println(x);
        }
    }
}
