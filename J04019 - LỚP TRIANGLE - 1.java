import java.util.*;
class Point{
    private double x, y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    public static Point nextPoint(Scanner sc){
        return new Point(sc.nextDouble(), sc.nextDouble());
    }
    public double distance(Point other){
        double x = this.x - other.x;
        double y = this.y - other.y;
        return Math.sqrt(x * x + y * y);
    }
}
class Triangle{
    private Point a, b, c;
    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public boolean valid(){
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        return ab + ac > bc && ab + bc > ac && ac + bc > ab;
    }
    public String getPerimeter(){
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        double p = ab + ac + bc;
        return String.format("%.3f", p);
    }
}
public class Solution{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
        public static void main9701889(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}
