import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
class Customer implements Comparable <Customer>{
    private String ID, name, loai;
    private int st, en;
    public Customer(int ID, String name, String loai, int st, int en){
        this.ID = "KH" + String.format("%02d", ID);
        this.name = name;
        this.loai = loai;
        this.st = st;
        this.en = en;
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
    public int getNorms(){
        if(loai.equals("A")) return 100;
        else if(loai.equals("B")) return 500;
        return 200;
    }
    public int getCoins(){
        int temp = this.en - this.st;
        if(temp <= this.getNorms()){
            return temp * 450;
        }else{
            return this.getNorms() * 450;
        }
    }
    public int getAddCharge(){
        int temp = this.en - this.st;
        if(temp > this.getNorms()){
            return (temp - this.getNorms()) * 1000;
        }
        return 0;
    }
    public int getTotal(){
        return this.getCoins() + this.getAddCharge() + this.getAddCharge() * 5 / 100;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getCoins() + " " + this.getAddCharge() + " " + this.getAddCharge() / 20 + " " + this.getTotal();
    }
    @Override
    public int compareTo(Customer other){
        return other.getTotal() - this.getTotal();
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int n = sc.nextInt();
        ArrayList <Customer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Customer a = new Customer(i, sc.nextLine(), sc.next(), sc.nextInt(), sc.nextInt());
            a.setName();
            arr.add(a);
        }
        Collections.sort(arr);
        for(Customer x : arr){
            System.out.println(x);
        }
    }
}
