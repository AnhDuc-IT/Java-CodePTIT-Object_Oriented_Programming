import java.util.*;
class Point{
    private double x, y;
    public Point(){
        this.x = this.y = 0;
    }
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
    }
    public static double distance(Point a, Point b){
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }
    public String toString(){
        return this.x + " " + this.y;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            Point c = new Point(sc.nextDouble(), sc.nextDouble());
            double a1 = a.distance(b);
            double b1 = b.distance(c);
            double c1 = c.distance(a);
            if(a1 + b1 <= c1 || a1 + c1 <= b1 || b1 + c1 <= a1){
                System.out.println("INVALID");
            }else{
                System.out.printf("%.3f\n",a1 + b1 + c1);
            }
        }
    }
}
