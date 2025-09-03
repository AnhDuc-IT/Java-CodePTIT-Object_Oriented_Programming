import java.util.*;
class Item{
    private String ID;
    private long quantity;
    public Item(String ID, long quantity){
        this.ID = ID;
        this.quantity = quantity;
    }
    public String getName(){
        String temp = this.ID.substring(this.ID.length() - 2);
        if(temp.equals("TN")) return "Trong Nuoc";
        if(temp.equals("BP")) return "British Petro";
        else if(temp.equals("ES")) return "Esso";
        else if(temp.equals("SH")) return "Shell";
        else if(temp.equals("CA")) return "Castrol";
        return "Mobil";
    }
    public long getPrice(){
        char temp = this.ID.charAt(0);
        if(temp == 'X') return 128000;
        else if(temp == 'D') return 11200;
        return 9700;
    }
    public long getTax(){
        char temp = this.ID.charAt(0);
        if(this.ID.substring(this.ID.length() - 2).equals("TN")) return 0;
        if(temp == 'X') return this.quantity * this.getPrice() * 3 / 100;
        else if(temp == 'D') return this.quantity * this.getPrice() * 35 / 1000;
        return this.quantity * getPrice() * 2 / 100;
    }
    public long getTotal(){
        return this.getTax() + this.quantity * this.getPrice();
    }
    public String toString(){
        return this.ID + " " + this.getName() + " " + this.getPrice() + " " + this.getTax() + " " + this.getTotal();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Item> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Item temp = new Item(sc.next(), sc.nextLong());
            arr.add(temp);
        }
        for(Item x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
