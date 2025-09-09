import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException.*;
class Item implements Comparable<Item>{
    private String ID, name, group;
    private double buy, pass;
    public Item(int ID, String name, String group, double buy, double pass){
        this.ID = "MH" + String.format("%02d", ID);
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
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("MATHANG.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Item> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Item a = new Item(i, br.readLine(), br.readLine(), Double.parseDouble(br.readLine()), Double.parseDouble(br.readLine()));
                arr.add(a);
            }
            Collections.sort(arr);
            for(Item x : arr){
                System.out.println(x);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
