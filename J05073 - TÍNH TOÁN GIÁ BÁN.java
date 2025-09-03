import java.lang.reflect.Array;
import java.util.*;
class Grocery{
    private String ID;
    double price, quantity;
    public Grocery(String ID, double price, double quantity){
        this.ID = ID;
        this.price = price;
        this.quantity = quantity;
    }
    public String getID(){
        return this.ID;
    }
    public double getPrice(){
        return this.price;
    }
    public double getQuantity(){
        return this.quantity;
    }
    public double getTax(){
        char s = this.ID.charAt(0);
        double ans = 0;
        if(s == 'T'){
            ans = 0.29;
        }else if(s == 'C'){
            ans = 0.1;
        }else if(s == 'D'){
            ans = 0.08;
        }else{
            ans = 0.02;
        }
        if(this.ID.charAt(ID.length() - 1) == 'C'){
            return ans * 0.95;
        }
        return ans;
    }
    public double getTrans(){
        char s = this.ID.charAt(0);
        if(s == 'T') return 0.04;
        else if(s == 'C') return 0.03;
        else if(s == 'D') return 0.025;
        return 0.005;
    }
    public double getTotal(){
        double res = this.price * this.quantity *(1 + this.getTax() + this.getTrans());
        return res * (1.2) / (1.0 * this.quantity);
    }
    public String toString(){
        return this.ID + " " + String.format("%.2f", getTotal());
    }
}

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Grocery> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String ID = sc.next();
            double price = sc.nextDouble();
            double quantity = sc.nextDouble();
            Grocery a = new Grocery(ID, price, quantity);
            arr.add(a);
        }
        for(Grocery x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
