import java.util.*;
class Item implements Comparable <Item>{
    private int ID;
    private String name, group;
    private double buy, pass;
    public Item(int ID, String name, String group, double buy, double pass){
        this.ID = ID;
        this.name = name;
        this.group = group;
        this.buy = buy;
        this.pass = pass;
    }
    public double getProfit(){
        return this.pass - this.buy;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.group + " " + String.format("%.2f", this.getProfit());
    }
    @Override
    public int compareTo(Item other){
        if(this.getProfit() > other.getProfit()) return -1;
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
            Item temp = new Item(i, sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble());
            arr.add(temp);
        }
        sc.close();
        Collections.sort(arr);
        for(Item x : arr){
            System.out.println(x);
        }
    }
}
