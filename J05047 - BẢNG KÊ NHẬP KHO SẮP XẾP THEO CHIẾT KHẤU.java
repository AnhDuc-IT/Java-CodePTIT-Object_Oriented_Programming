
import java.util.*;
class Item{
    private String ID, name;
    private long quantity, price;
    public Item(String ID,String name, long quantity, long price){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getID(){
        String[] a = this.name.split(" ");
        String res = "";
        res += Character.toUpperCase(a[0].charAt(0)) + Character.toUpperCase(a[1].charAt(0));
        return res;
    }
    public long ChietKhau(){
        if(this.quantity > 10){
            return this.price * this.quantity * 5 / 100;
        }
        else if(this.quantity >= 8){
            return this.price * this.quantity * 2 / 100;
        }
        else if(this.quantity >= 5){
            return this.price * this.quantity / 100;
        }
        return 0;
    }
    public long getTotal(){
        return this.price * this.quantity - this.ChietKhau();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.ChietKhau() + " " + this.getTotal();
    }
}
public class Solution{
    public static String change(String s){
        String[] a = s.split(" ");
        String res = "";
        for(int i = 0; i <= 1; i++){
            res += Character.toUpperCase(a[i].charAt(0));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Item> arr = new ArrayList<>();
        HashMap <String, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            String name = sc.nextLine();
            long Quantity = sc.nextLong();
            long Price = sc.nextLong();
            String Change = change(name);
            if(!map.containsKey(Change)){
                map.put(Change, 1);
            }else{
                map.put(Change, map.get(Change) + 1);
            }
            String ID = change(name) + "0" + map.get(Change);
            Item temp = new Item(ID, name, Quantity, Price);
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2){
                if(o1.ChietKhau() > o2.ChietKhau()) return -1;
                return 1;
            }
        });
        for(Item x : arr){
            System.out.println(x);
        }
    }
}
