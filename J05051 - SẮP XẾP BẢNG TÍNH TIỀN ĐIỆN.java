
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
    public char getID(){
        return this.ID.charAt(0);
    }
}
class Electricity{
    private String ID, name;
    private long old;
    private long New;
    public Electricity(String ID, int name, long old, long New){
        this.ID = ID;
        this.name = "KH" + String.format("%02d", name);
        this.old = old;
        this.New = New;
    }
    public int getIndex(){
        if(this.ID.equals("KD")) return 3;
        else if(this.ID.equals("NN")) return 5;
        else if(this.ID.equals("TT")) return 4;
        return 2;
    }
    public long getPrice(){
        return 1l * (this.New - this.old) * this.getIndex() * 550;
    }
    public long getAdd(){
        long temp = this.New - this.old;
        if(temp < 50) return 0;
        else if(temp <= 100){
            return (long)Math.round(1.0 * this.getPrice() * 35 / 100.0);
        }
        return this.getPrice();
    }
    public long getTotal(){
        return this.getPrice() + this.getAdd();
    }
    public String toString(){
        return this.name + " " + this.getIndex() + " " + this.getPrice() + " " + this.getAdd() + " " + this.getTotal();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Electricity> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Electricity a = new Electricity(sc.nextLine(), i, sc.nextLong(), sc.nextLong());
            arr.add(a);
        }
        Collections.sort(arr, new Comparator <Electricity>(){
            @Override
            public int compare(Electricity o1, Electricity o2){
                if(o1.getTotal() > o2.getTotal()) return -1;
                return 1;
            }
        });
        for(Electricity x : arr){
            System.out.println(x);
        }
    }
}
