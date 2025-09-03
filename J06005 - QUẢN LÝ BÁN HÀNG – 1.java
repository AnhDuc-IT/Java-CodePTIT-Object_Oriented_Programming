import java.util.*;
class Customer{
    private String ID, name, sex, birth, adress;
    public Customer(int ID, String name, String sex, String birth, String adress){
        this.ID = "KH" + String.format("%03d", ID);
        this.name = name;
        this.birth = birth;
        this.sex = sex;
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
    public String getBirth(){
        return this.birth;
    }
}
class Product{
    private String code, Name, init;
    private long buy, pass;
    public Product(int code, String name, String init, long buy, long pass){
        this.code = "MH" + String.format("%03d", code);
        this.Name = name;
        this.init = init;
        this.buy = buy;
        this.pass = pass;
    }
    public String getCode(){
        return this.code;
    }
    public String getNAme(){
        return this.Name;
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
    private String id;
    private int quantity;
    private Customer customer;
    private Product product;
    public Receipt(int id, int quantity, Customer customer, Product product){
        this.id = "HD" + String.format("%03d", id);
        this.quantity = quantity;
        this.customer = customer;
        this.product = product;
    }

    public String toString(){
        return this.id + " " + this.customer.getName() + " " + this.customer.getAdress() + " " + this.product.getNAme() + " " + this.product.getInit() + " " + this.product.getBuy() + " "  + this.product.getPass() + " " + this.quantity + " " + this.product.getPass() * this.quantity;
     }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, Customer> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            Customer a = new Customer(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            map.put(a.getID(), a);
        }
        int m = sc.nextInt();
        Map <String, Product> mp = new HashMap<>();
        for(int i = 1; i <= m; i++){
            sc.nextLine();
            Product a = new Product(i, sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong());
            mp.put(a.getCode(), a);
        }
        int p = sc.nextInt();
        ArrayList <Receipt> arr = new ArrayList<>();
        for(int i = 1; i <= p; i++){
            String s = sc.next();
            String ss = sc.next();
            int sss = sc.nextInt();
            Receipt a = new Receipt(i, sss, map.get(s), mp.get(ss));
            arr.add(a);  
        }
        for(Receipt x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
