
import java.util.*;
class Cloth{
    private String name, ID;
    private long price, quantity;
    public Cloth(String name, String ID, long price, long quantity){
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.quantity = quantity;
    }
    public String getID(){
        return this.ID.substring(1, 4);
    }
    public long getPrice(){
        return this.quantity * this.price;
    }
    public long getDiscount(){
        if(this.ID.charAt(this.ID.length() - 1) == '1'){
            return this.price * this.quantity * 5 / 10;
        }
        return this.price * this.quantity * 3 / 10;
    }
    public long getCharge(){
        return this.quantity * this.price - this.getDiscount();
    }
    public String toString(){
        return this.name + " " + this.ID + " " + this.getID() + " " + this.getDiscount() + " " + this.getCharge();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Cloth> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Cloth a = new Cloth(sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong());
            arr.add(a);
        }
        Collections.sort(arr, new Comparator<Cloth>(){
            public int compare(Cloth o1, Cloth o2){
                return o1.getID().compareTo(o2.getID());
            }
        });
        for(Cloth x : arr){
            System.out.println(x);
        }
    }
}
