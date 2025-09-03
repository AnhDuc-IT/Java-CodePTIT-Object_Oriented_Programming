import java.util.*;
class Bill implements Comparable<Bill>{
    private String ID, name;
    private int New, Old;
    public Bill(int ID, String name, int Old, int New){
        this.ID = "KH" + String.format("%02d", ID);
        this.name = name;
        this.New = New;
        this.Old = Old;
    }
    public int getFee(){
        int temp = this.New - this.Old;
        if(temp > 100){
            return (int)Math.round((50 * 100  + 50 * 150 + (temp - 100) * 200) * 105 / 100.0);
        }else if(temp >= 51 && temp <= 100){
            return (int)Math.round((50 * 100  + (temp - 50) * 150) * 103.0 / 100.0);
        }else{
            return (int)Math.round(100 * temp * 102.0 / 100.0);
        }
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getFee();
    }
    @Override
    public int compareTo(Bill other){
        if(this.getFee() > other.getFee()) return -1;
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Bill> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Bill a = new Bill(i, sc.nextLine(), sc.nextInt(), sc.nextInt());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Bill x : arr){
            System.out.println(x);
        }
    }
}
