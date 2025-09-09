import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Product{
    private String ID, name;
    private long price, warranty;
    public Product(String ID, String name, long price, long warranty){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.warranty = warranty;
    }
    public String getID(){
        return this.ID;
    }
    public long getPrice(){
        return this.price;
    }
    public long getWarranty(){
        return this.warranty;
    }
}
class Customer implements Comparable<Customer>{
    private String code, nameKH, adress, codeProduct, date;
    private long quantity;
    private Product product;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Customer(int code, String nameKH, String adress, String codeProduct, long quantity, String date, Product product){
        this.code = "KH" + String.format("%02d", code);
        this.nameKH = nameKH;
        this.adress = adress;
        this.codeProduct = codeProduct;
        this.quantity = quantity;
        this.date = date;
        this.product = product;
    }
    public LocalDate getDate(){
        String[] a = this.date.split("/");
        LocalDate dateNow = LocalDate.of(Integer.parseInt(a[2]), Integer.parseInt(a[1]), Integer.parseInt(a[0]));
        LocalDate dateNew = dateNow.plusMonths(this.product.getWarranty());
        return dateNew;
    }
    public String toString(){
        return this.code + " " + this.nameKH + " " + this.adress + " " + this.product.getID() + " " + this.quantity * this.product.getPrice() + " " + this.getDate().format(FORMATTER);
    }
    public String Convert(String s){
        String[] a = s.split("/");
        return a[2] + a[1] + a[0];
    }
    @Override
    public int compareTo(Customer other){
        int cmp = this.getDate().compareTo(other.getDate());
        if(cmp == 0) return this.code.compareTo(other.code);
        return cmp;
    }
}
public class Solution{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map <String, Product> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Product a = new Product(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt());
            map.put(a.getID(), a);
        }
        ArrayList <Customer> arr = new ArrayList<>();
        int m = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= m; i++){
            String name = sc.nextLine();
            String adress = sc.nextLine();
            String codeProduct = sc.nextLine();
            int quantity = sc.nextInt(); sc.nextLine();
            String date = sc.nextLine();
            Customer a = new Customer(i, name, adress, codeProduct, quantity, date, map.get(codeProduct));
            arr.add(a);
        }
        Collections.sort(arr);
        for(Customer x : arr){
            System.out.println(x);
        }
    }
}
