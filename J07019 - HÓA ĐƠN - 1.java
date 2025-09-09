import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException.*;
class Cloth{
    private String ID, name;
    private long cloth1, cloth2;
    public Cloth(String ID, String name, long cloth1, long cloth2){
        this.ID = ID;
        this.name = name;
        this.cloth1 = cloth1;
        this.cloth2 = cloth2;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public long getPrice1(){
        return this.cloth1;
    }
    public long getPrice2(){
        return this.cloth2;
    }
}
class Receipt{
    private String code;
    private long quantity;
    private Cloth cloth;
    public Receipt(String code, int cnt, long quantity, Cloth cloth){
        this.cloth = cloth;
        this.code = code;
        this.code += "-" + String.format(("%03d"), cnt);
        this.quantity = quantity;
    }
    public long getPrice(){
        if(this.code.charAt(2) == '1') return this.cloth.getPrice1();
        return this.cloth.getPrice2();
    }
    public long getDiscount(){
        long temp = 1l * this.quantity * this.getPrice();
        if(this.quantity >= 150){
            return temp * 1 / 2;
        }else if(this.quantity >= 100){
            return temp * 3 / 10;
        }else if(this.quantity >= 50){
            return temp * 15 / 100;
        }
        return 0;
    }
    public long getTotal(){
        return this.quantity * this.getPrice() - this.getDiscount();
    }
    public String toString(){
        return this.code + " " + this.cloth.getName() + " " + this.getDiscount() + " " + this.getTotal();
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader bw = new BufferedReader(new FileReader("DATA1.in"));
            BufferedReader bw2 = new BufferedReader(new FileReader("DATA2.in"));
            ArrayList <Receipt> arr = new ArrayList<>();
            int n = Integer.parseInt(bw.readLine());
            Map <String, Cloth> map = new HashMap<>();
            for(int i = 1; i <= n; i++){
                Cloth a = new Cloth(bw.readLine(), bw.readLine(), Long.parseLong(bw.readLine()), Long.parseLong(bw.readLine()));
                map.put(a.getID(), a);
            }
            int m = Integer.parseInt(bw2.readLine());
            for(int i = 1; i <= m ;i++){
                String[] a  = bw2.readLine().split(" ");
                Receipt temp = new Receipt(a[0], i, Long.parseLong(a[1]), map.get(a[0].substring(0, 2)));
                arr.add(temp);
            }
            for(Receipt x : arr){
                System.out.println(x);
            }
            bw.close();
            bw2.close();
        } catch (Exception e) {
        }
    }
}
