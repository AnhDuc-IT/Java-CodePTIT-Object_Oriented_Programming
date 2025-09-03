import java.util.*;
class Cloth{
    private String ID, name;
    private long price1, price2;
    public Cloth(String ID, String name, long price1, long price2){
        this.ID = ID;
        this.name = name;
        this.price1 = price1;
        this.price2 = price2;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public long getPrice1(){
        return this.price1;
    }
    public long getPrice2(){
        return this.price2;
    }
}
class Bill extends Cloth{
    private String code;
    private long quantity;
    public Bill(int i, String code, long quantity, Cloth a){
        super(a.getID(), a.getName(), a.getPrice1(), a.getPrice2());
        this.code = code + "-" + String.format("%03d", i);
        this.quantity = quantity;
    }
    public String getCode(){
        return this.code;
    }
    public long getDiscount(){
        char s = this.code.charAt(2);
        if(s == '1'){
            if(this.quantity < 50) return 0;
            if(this.quantity < 100){
                return this.quantity * this.getPrice1() * 15 / 100;
            }else if(this.quantity < 150){
                return this.quantity * this.getPrice1() * 30 / 100;
            }else{
                return this.quantity * this.getPrice1() * 1 / 2;
            }
        }else{
            if(this.quantity < 50) return 0;
            if(this.quantity < 100){
                return this.quantity * this.getPrice2() * 15/ 100;
            }else if(this.quantity < 150){
                return this.quantity * this.getPrice2() * 3 / 10;
            }else{
                return this.quantity * this.getPrice2() * 1 / 2;
            }
        }
    }
    public long getTotal(){
        char s = this.code.charAt(2);
        if(s == '1'){
            return this.quantity * this.getPrice1() - this.getDiscount();
        }else{
            return this.quantity * this.getPrice2() - this.getDiscount();
        }
    }
    public String toString(){
        return this.getCode() + " " + this.getName() + " " + this.getDiscount() + " " + this.getTotal();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        Map <String, Cloth> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Cloth a = new Cloth(sc.nextLine(), sc.nextLine(),sc.nextLong(), sc.nextLong());
            map.put(a.getID(), a);
        }
        ArrayList <Bill> arr = new ArrayList<>();
        int m = sc.nextInt();
        for(int i = 1; i <= m; i++){
            String code = sc.next();
            long quantity = sc.nextLong();
            Bill a = new Bill(i, code, quantity, map.get(code.substring(0,2)));
            arr.add(a);
        }
        for(Bill x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
