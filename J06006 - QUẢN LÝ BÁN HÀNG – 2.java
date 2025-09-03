import java.util.*;
class Customer{
    private String ID, name, sex, birth, adress;
    public Customer(int ID, String name, String sex, String birth, String adress){
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
    public String getTen(){
        return this.ten;
    }
    public String getInit(){
        return this.init;
    }
    public String getCode(){
        return this.code;
    }
    public long getBuy(){
        return this.buy;
    }
    public long getPass(){
        return this.pass;
    }
}
class Receipt implements Comparable<Receipt>{
    private String id;
    private long quantity;
    private Customer customer;
    private Product product;
    public Receipt(int id, int quantity, Customer customer, Product product){
        this.id = "HD" + String.format("%03d", id);
        this.customer = customer;
        this.quantity = quantity;
        this.product = product;
    }
    public long getCharge(){
        return this.quantity * this.product.getPass();
    }
    public long getProfit(){
        return this.quantity * (this.product.getPass() - this.product.getBuy());
    }
    public String toString(){
        return this.id + " " + this.customer.getName() + " " + this.customer.getAdress() + " " + this.product.getTen() + " " + this.quantity + " " + this.getCharge() + " " + this.getProfit();
    }
    @Override
    public int compareTo(Receipt other){
        if(this.getProfit() > other.getProfit()) return -1;
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Map <String, Customer> map = new HashMap();
        int n = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= n; i++){
            Customer a = new Customer(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            map.put(a.getID(), a);
        }
        int m = sc.nextInt();
        Map <String, Product> mp = new HashMap<>();
        for(int i = 1; i <= m; i++){
            sc.nextLine();
            Product a = new Product(i, sc.nextLine(), sc.nextLine(),sc.nextLong(), sc.nextLong());
            mp.put(a.getCode(), a);
        }
        ArrayList <Receipt> arr = new ArrayList<>();
        int p = sc.nextInt();
        for(int i = 1; i <= p; i++){
            String s = sc.next();
            String ss = sc.next();
            int sss = sc.nextInt();
            Receipt a = new Receipt(i, sss, map.get(s), mp.get(ss));
            arr.add(a);
        }
        Collections.sort(arr);
        for(Receipt a : arr){
            System.out.println(a);
        }
        sc.close();
    }
}
