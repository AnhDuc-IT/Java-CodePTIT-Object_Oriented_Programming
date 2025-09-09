import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Customer implements Comparable<Customer>{
    private String ID, name, sex, birth, adress;
    public Customer(int ID, String name, String sex, String birth, String adress){
        this.ID = "KH" + String.format("%03d", ID);
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.adress = adress;
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
    public void setBirth(){
        StringBuilder sb = new StringBuilder(this.birth);
        if(sb.charAt(2) != '/') sb.insert(0, "0");
        if(sb.charAt(5) != '/') sb.insert(3, "0");
        this.birth = sb.toString();
    }
    public String getBirth(){
        String[] a = this.birth.split("/");
        return a[2] + a[1] + a[0];
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.sex + " " + this.adress + " " + this.birth;
    }
    @Override
    public int compareTo(Customer other){
        return this.getBirth().compareTo(other.getBirth());
    }
}
public class Solution{
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("KHACHHANG.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Customer> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Customer a = new Customer(i, br.readLine(), br.readLine(), br.readLine(), br.readLine());
                a.setBirth();
                a.setName();
                arr.add(a);
            }
            Collections.sort(arr);
            for(Customer x : arr){
                System.out.println(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
