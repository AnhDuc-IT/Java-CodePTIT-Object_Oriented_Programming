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
class Phone implements Comparable <Phone>{
    private String code, st, end;
    private Customer customer;
    public Phone(String code, String st, String end, Customer customer){
        this.code = code;
        this.st = st;
        this.end = end;
        this.customer = customer;
    }
    public long getTime(){
        String[] a = this.st.split(":");
        String[] b = this.end.split(":");
        long res = Integer.parseInt(b[0]) * 60 - Integer.parseInt(a[0]) * 60 + Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
        if(this.code.charAt(0) != '0'){
            return (long)Math.ceil(1.0 * res / 3.0);
        }
        return res;
    }
    public long getCharge(){
        return this.getTime() * this.customer.getPrice();
    }
    @Override
    public int compareTo(Phone other){
        if(this.getCharge() > other.getCharge()) return -1;
        return 1;
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
            sc.nextLine();
            String ID = sc.nextLine();
            String name = sc.nextLine();
            long price = sc.nextLong();
            if(ID.length() != 3){
                ID = "0" + ID;
            }
            Customer a = new Customer(ID, name, price);
            map.put(ID, a);
        }
        int m = sc.nextInt();
        ArrayList <Phone> arr = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            String code = sc.next();
            String st = sc.next();
            String end = sc.next();
            if(!map.containsKey(code.substring(0, 3))){
                Phone s = new Phone(code, st, end, new Customer(code, "Noi mang", 800));
                arr.add(s);
            }else{
                Phone s = new Phone(code, st, end, map.get(code.substring(0, 3)));
                arr.add(s);
            }
        }
        Collections.sort(arr);
        for(Phone x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
