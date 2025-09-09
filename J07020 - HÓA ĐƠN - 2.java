import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException.*;
import java.lang.reflect.Array;
class Customer{
    private String ID, name, sex, birth, adress;
    public Customer(int ID, String name, String sex,  String birth, String adress){
        this.sex = sex;
        this.ID = "KH" + String.format("%03d", ID);
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.adress = adress;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getAdress(){
        return this.adress;
    }
}
class Product{
    private String code, ten, init;
    private long buy, pass;
    public Product(int code, String ten, String init, long buy, long pass){
        this.code = "MH" + String.format("%03d", code);
        this.ten = ten;
        this.init = init;
        this.buy = buy;
        this.pass = pass;
    }
    public String getCode(){
        return this.code;
    }
    public String getTen(){
        return this.ten;
    }
    public String getInit(){
        return this.init;
    }
    public long getBuy(){
        return this.buy;
    }
    public long getPass(){
        return this.pass;
    }
}
class Receipt{
    private long quantity;
    private String id;
    private Customer customer;
    private Product product;
    public Receipt(int id, Customer customer, Product product, long quantity){
        this.id = "HD" + String.format("%03d", id);
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }
    public long getTotal(){
        return this.quantity * this.product.getPass();
    }
    public String toString(){
        return this.id + " " + this.customer.getName() + " " + this.customer.getAdress() + " " + this.product.getTen() + " " + this.product.getInit() + " " + this.product.getBuy() + " " + this.product.getPass() + " " + this.quantity + " " + this.getTotal();
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("KH.in"));
            BufferedReader br2 = new BufferedReader(new FileReader("MH.in"));
            BufferedReader br3 = new BufferedReader(new FileReader("HD.in"));
            Map <String, Customer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int i = 1; i <= n; i++){
                Customer a = new Customer(i, br.readLine(), br.readLine(), br.readLine(), br.readLine());
                map.put(a.getID(), a);
            }
            Map <String, Product> mp = new HashMap<>();
            int m = Integer.parseInt(br2.readLine());
            for(int i = 1; i <= m; i++){
                Product a = new Product(i, br2.readLine(), br2.readLine(), Long.parseLong(br2.readLine()), Long.parseLong(br2.readLine()));
                mp.put(a.getCode(), a);
            }
            ArrayList <Receipt> arr = new ArrayList<>();
            int p = Integer.parseInt(br3.readLine());
            for(int i = 1; i <= m; i++){
                String[] a = br3.readLine().split("\\s+");
                Receipt b = new Receipt(i, map.get(a[0]), mp.get(a[1]), Long.parseLong(a[2]));
                arr.add(b);
            }
            for(Receipt x : arr){
                System.out.println(x);
            }
            br.close();
            br2.close();
            br3.close();
        } catch (Exception e) {
        }
    }
}
