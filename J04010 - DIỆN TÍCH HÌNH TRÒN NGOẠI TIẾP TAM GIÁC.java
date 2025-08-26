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
class Point{
    private double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n ;i++){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());
            double a1 = a.distance(b);
            double b1 = b.distance(c);
            double c1 = c.distance(a);
            if(a1 + b1 <= c1 || a1 + c1 <= b1 || b1 + c1 <= a1){
                System.out.println("INVALID");
            }else{
                double p = (a1 + b1 + c1) / 2.000;
                double Area = Math.sqrt(1.000 * p * (p - a1) * (p - b1) * (p - c1));
                double R = 1.0 * a1 * b1 * c1 / (4.0 * Area);
                System.out.printf("%.3f\n", R * R * Math.PI);
            }
        }
    }
}
