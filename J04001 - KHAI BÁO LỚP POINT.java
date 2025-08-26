import java.util.*;
class Point{
    private double x, y;
    public Point(){}
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Point(Point other){
        this.x = other.x;
        this.y = other.y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double distance(Point other){
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    public double distance(Point a, Point b){
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
    public String toString(){
        return this.x + " " + this.y;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            Point a = new Point(sc.nextDouble(), sc.nextDouble());
            Point b = new Point(sc.nextDouble(), sc.nextDouble());
            System.out.printf("%.4f",a.distance(b));
            System.out.println();
        }
        sc.close();
    }
}
