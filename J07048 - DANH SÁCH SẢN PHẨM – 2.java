import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException.*;
class Item implements Comparable<Item>{
    private String ID, name;
    private int price, warranty;
    public Item(String ID, String name, int price, int warranty){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }
    @Override
    public int compareTo(Item other){
        if(this.price == other.price){
            return this.ID.compareTo(other.ID);
        }
        return other.price - this.price;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.price + " " + this.warranty;
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{

        try {
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally{
            Scanner sc = new Scanner(new File("SANPHAM.in"));
            int n = sc.nextInt();
            ArrayList <Item> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                sc.nextLine();
                Item a = new Item(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());
                arr.add(a);
            }
            Collections.sort(arr);
            for(Item x : arr){
                System.out.println(x);
            }
        }
    }
}
