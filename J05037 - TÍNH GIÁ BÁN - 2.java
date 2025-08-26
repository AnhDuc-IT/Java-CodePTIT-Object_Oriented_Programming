import java.util.*;
class Glocery{
    private String ID, name, init;
    private int price, quantity;
    public Glocery(int ID, String name, String init, int price, int quantity){
        this.ID = "MH" + String.format("%02d", ID);
        this.name = name;
        this.init = init;
        this.price = price;
        this.quantity = quantity;
    }
    public int getTrans(){
        double res = 1.0 * this.price * quantity * 0.05;
        res = Math.round(res);
        return (int)res;
    }
    public int getPrice(){
        return this.getTrans() + this.price * this.quantity;
    }
    public int getTotal(){
        double res = (this.getPrice() * 1.02) / this.quantity;
        return (int)Math.ceil(res / 100.0) * 100;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.init + " " + this.getTrans() + " " + this.getPrice() + " " + this.getTotal();

    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Glocery> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Glocery temp = new Glocery(i, sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator <Glocery>(){
            @Override
            public int compare(Glocery o1, Glocery o2){
                return o2.getTotal() - o1.getTotal();
            }
        });
        for(Glocery x : arr){
            System.out.println(x);
        }
    }
}
