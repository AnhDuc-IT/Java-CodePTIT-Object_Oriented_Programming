import java.util.*;
class Student{
    private String ID, name;
    private double math, physic, chemistry;

    public Student(String ID, String name, double math, double physic, double chemistry){
        this.ID = ID;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
        this.name = name;
    }
    public double getScore(){
        double ans = this.math * 2 + this.chemistry + this.physic;
        return Math.round(ans * 10.0) / 10.0;
    }
    public double getAdd(){
        char temp = this.ID.charAt(2);
        if(temp == '1') return 0.5;
        if(temp == '2') return 1;
        return 2.5;
    } 
    public String getResult(){
        if(getScore() + getAdd() >= 24) return "TRUNG TUYEN";
        return "TRUOT";
    }
    public String toString(){
        int temp = (int)getScore();
        if(temp == getScore()){
            return this.ID + " " + this.name + " " + (int)this.getAdd() + " " + temp + " " + getResult();
        }else{
            return this.ID + " " + this.name + " " + (int)this.getAdd() + " " + getScore() + " " + this.getResult();
        }
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(a);
    }
}
