import java.util.*;
class Inventory{
    private String ID;
    private long quantity;
    public Inventory(String ID, long quantity){
        this.ID = ID;
        this.quantity = quantity;
    }
    public long getExport(){
        double res = 1.0;
        if(this.ID.charAt(0) == 'A'){
            res = 1.0 * res * this.quantity * 0.6;
        }else{
            res = 1.0 * res * this.quantity * 0.7;
        }
        return (long)Math.round(res);
    }
    public long getPrice(){
        if(this.ID.charAt(this.ID.length() - 1) == 'Y'){
            return 110000;
        }
        return 135000;
    }
    public long getCharge(){
        return 1l * this.getExport() * this.getPrice();
    }
    public long getTax(){
        int n = this.ID.length();
        if(this.ID.charAt(0) == 'A'){
            if(this.ID.charAt(n - 1) == 'Y'){
                return this.getCharge() * 8 / 100;
            }else{
                return this.getCharge() * 11 / 100;
            }
        }else{
            if(this.ID.charAt(n - 1) == 'Y'){
                return this.getCharge() * 17 / 100;
            }
            return this.getCharge() * 22 / 100;
        }
    }
    public String toString(){
        return this.ID + " " + this.quantity + " " + this.getExport() + " " + this.getPrice() + " " + this.getCharge() + " " + this.getTax();
    }
}

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Inventory> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Inventory a = new Inventory(sc.nextLine(), sc.nextLong());
            arr.add(a);
        }
        for(Inventory x : arr){
            System.out.println(x);
        }
    }
}
