import java.util.*;
class Customer{
    private String ID, name;
    private long price;
    public Customer(String ID, String name, long price){
        this.ID = ID;
        this.name = name;
        this.price = price;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public long getPrice(){
        return this.price;
    }
}
class Phone{
    private String code, start, end;
    private Customer customer;
    public Phone(String code, String start, String end, Customer customer){
        this.code = code;
        this.start = start;
        this.end = end;
        this.customer = customer;
    }
    public String getCode(){
        return this.code;
    }
    public long getTime(){
        String[] a = this.start.split(":");
        String[] b = this.end.split(":");
        int hour = (Integer.parseInt(b[0]) - Integer.parseInt(a[0])) * 60 + Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
        if(this.code.charAt(0) != '0') return (long)Math.ceil(1.0 * hour / 3.0);
        return hour;
    }
    public long getCharge(){
        return this.getTime() * this.customer.getPrice();
    }
    public String toString(){
        return this.code + " " + this.customer.getName() + " " + this.getTime() + " " + this.getCharge();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        Map <String, Customer> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            int temp = sc.nextInt();
            String ID = "" + temp;
            if(ID.length() != 3){
                ID = "0" + ID;
            }
            sc.nextLine();
            String name = sc.nextLine();
            long price = sc.nextLong();
            Customer a = new Customer(ID, name, price);
            map.put(ID, a);
        }
        ArrayList <Phone> arr = new ArrayList<>();
        int m = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= m; i++){
            String line = sc.nextLine();
            String[] a = line.split(" ");
            String code = a[0];
            String start = a[1];
            String end = a[2];
            if(!map.containsKey(code.substring(0, 3))){
                Phone s = new Phone(code, start, end, new Customer(code, "Noi mang", 800));
                arr.add(s);
            }else{
                Phone s = new Phone(code, start, end, map.get(code.substring(0, 3)));
                arr.add(s);
            }
        }
        for(Phone x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
