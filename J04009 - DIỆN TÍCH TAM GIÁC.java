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
        return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y),2));
    }
    public static double distance(Point a, Point b){
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
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
            Point c = new Point(sc.nextDouble(), sc.nextDouble());
            double ans_a = a.distance(b);
            double ans_b = b.distance(c);
            double ans_c = c.distance(a);
            if(ans_a + ans_b <= ans_c || ans_a + ans_c <= ans_b || ans_b + ans_c <= ans_a){
                System.out.println("INVALID");
            } else{
                double p = (ans_a + ans_b + ans_c) / 2.0;
                double area = Math.sqrt(p * (p - ans_a) * (p - ans_b) * (p - ans_c));
                System.out.printf("%.2f\n",area);
            }
        }
    }
}
