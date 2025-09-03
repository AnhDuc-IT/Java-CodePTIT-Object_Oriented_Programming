import java.util.*;
class Rain{
    private String ID, name, start, end;
    private double average;
    public Rain(int ID ,String name, String start, String end, double average){
        this.ID = "T" + String.format("%02d", ID);
        this.name = name;
        this.start = start;
        this.end = end;
        this.average = average;
    }
    public String getName(){
        return this.name;
    }
    public double getTime(){
        String[] a = this.start.split(":");
        String[] b = this.end.split(":");
        double temp = (Integer.parseInt(b[0]) - Integer.parseInt(a[0])) * 60 + (Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        return 1.0 * temp;
    }
    public double getAverage(){
        return this.average;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + String.format("%.2f", this.average);
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <String> ar = new ArrayList<>();
        ArrayList <Rain> arr = new ArrayList<>();
        int cnt = 1;
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Rain a = new Rain(cnt, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
            if(!ar.contains(a.getName())){
                ar.add(a.getName());
                ++cnt;
            }
            arr.add(a);
        }
        ArrayList <Rain> res = new ArrayList<>();
        int index = 1;
        for(String x : ar){
            double ans = 0;
            int count = 0;
            for(Rain it : arr){
                if(it.getName().equals(x)){
                    ans += it.getAverage();
                    count += it.getTime();
                }
            }
            ans /= (1.0 * count);
            ans *= 60.0;
            Rain b = new Rain(index, x, "", "", ans);
            ++index;
            res.add(b);
        }
        for(Rain x : res){
            System.out.println(x);
        }
    }
}
