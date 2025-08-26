import java.util.*;
class HocBong {
    private String name;
    private double GPA;
    private int DRL;
    public HocBong(String name, double GPA, int DRL){
        this.name = name;
        this.GPA = GPA;
        this.DRL = DRL;
    }
    public String getHocBong(){
        if(this.GPA >= 3.6 && this.DRL >= 90) return "XUATSAC";
        if(this.GPA >= 3.2 && this.DRL >= 80) return "GIOI";
        if(this.GPA >= 2.5 && this.DRL >= 70) return "KHA";
        return "KHONG";
    }
    public boolean check(){
        return !getHocBong().equals("KHONG");
    }

    public double getGPA(){ return this.GPA; }
    public int getDRL(){ return this.DRL; }
    public String getName(){ return this.name; }
    @Override
    public String toString(){
        return this.name + ": " + getHocBong();
    }
}
class Point{
    private int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getArea1(Point other){
        return this.x * other.y;
    }
    public int getArea2(Point other){
        return this.y * other.x;
    }
}
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            double ans = 0;
            double res = 0;
            ArrayList <Point> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Point a = new Point(sc.nextInt(), sc.nextInt());
                arr.add(a);
            }
            for(int i = 0; i < n - 1; i++){
                ans += arr.get(i).getArea1(arr.get(i + 1));
                res += arr.get(i).getArea2(arr.get(i + 1));
            }
            ans += arr.get(n - 1).getArea1(arr.get(0));
            res += arr.get(n - 1).getArea2(arr.get(0));
            System.out.printf("%.3f",Math.abs(res - ans) / 2.0);
            System.out.println();
        }
    }
}
