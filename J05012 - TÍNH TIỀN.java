import java.util.*;
class Item implements Comparable <Item>{
    private String ID, name;
    private long quantity, price, discount;
    public Item(String ID, String name, long quantity, long price, long discount){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }
    public long getAns(){
        return this.quantity * this.price - this.discount;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.quantity + " " + this.price + " " + this.discount + " " + this.getAns();
    }
    @Override
    public int compareTo(Item other){
        if(this.getAns() > other.getAns()) return -1;
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Item> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Item a = new Item(sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong(), sc.nextLong());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Item x : arr){
            System.out.println(x);
        }
    }
}
