import java.lang.reflect.Array;
import java.util.*;
class Customer implements Comparable <Customer>{
    private String ID, name, sex, birth, adress;
    public Customer(int ID, String name, String sex, String birth, String adress){
        this.ID = "KH" + String.format("%03d", ID);
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.adress = adress;
    }
    public String getBirth(){
        StringBuilder sb = new StringBuilder(this.birth);
        if(sb.charAt(2) != '/') sb.insert(0, "0");
        if(sb.charAt(5) != '/') sb.insert(3, '0');
        return sb.toString();
    }
    @Override
    public int compareTo(Customer other){
        this.birth = getBirth();
        String[] a = this.getBirth().split("/");
        String res = "";
        for(String x : a){
            res = x + res;
        }
        String ans = "";
        String[] b = other.getBirth().split("/");
        for(String x : b){
            ans = x + ans;
        }
        return res.compareTo(ans);
    }
    public void setName(){
        String[] a = this.name.trim().split("\\s+");
        String res = "";
        for(String x : a){
            res += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length(); i++){
                res += Character.toLowerCase(x.charAt(i));
            }
            res += " ";
        }
        this.name = res.trim();
    }
    public String toString(){
        setName();
        this.birth = getBirth();
        return this.ID + " " + this.name + " " + this.sex + " " + this.adress + " " + this.getBirth();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList <Customer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Customer x = new Customer(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Customer x : arr){
            System.out.println(x);
        }
        sc.close();
    }
} 
