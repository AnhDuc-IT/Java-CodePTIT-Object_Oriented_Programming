import java.lang.reflect.Array;
import java.util.*;
class Item{
    private String code, name;
    private char ID;
    public Item(String code, String name, char ID){
        this.code = code;
        this.name = name;
        this.ID = ID;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public char getID(){
        return this.ID;
    }
}
class Bill extends Item{
    private String id;
    private long Import, price, Export;
    public Bill(String id, long Import, long price, long Export, Item a){
        super(a.getCode(), a.getName(), a.getID());
        this.id = id;
        this.Import = Import;
        this.Export = Export;
        this.price = price;
    }
    public long getImport(){
        return this.Import * this.price;
    }
    public long getExport(){
        if(this.getID() == 'A'){
            return this.Export * this.price * 108 / 100;
        }else if(this.getID() == 'B'){
            return this.Export * this.price * 105 / 100;
        }
        return this.Export * this.price * 102 / 100;
    }
    public String toString(){
        return this.getCode() + " " + this.getName() + " " + this.getImport() + " " + this.getExport();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, Item> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            Item a = new Item(sc.nextLine(), sc.nextLine(), sc.nextLine().charAt(0));
            map.put(a.getCode(), a);
        }
        ArrayList <Bill> arr = new ArrayList<>();
        int m = sc.nextInt();
        for(int i = 1; i <= m; i++){
            String id = sc.next();
            long Import = sc.nextLong();
            long price = sc.nextLong();
            long Export = sc.nextLong();
            Bill a = new Bill(id, Import, price, Export, map.get(id));
            arr.add(a);
        }
        for(Bill x : arr){
            System.out.println(x);
        }
        sc.close();
    }
} 
