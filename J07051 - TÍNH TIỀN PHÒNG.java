import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Customer implements Comparable<Customer>{
    private String ID, name, in, out;
    private String room;
    private long addCharge;
    public Customer(int ID, String name, String room, String in, String out, long addCharge){
        this.ID = "KH" + String.format("%02d", ID);
        this.name = name;
        this.room = room;
        this.in = in;
        this.out = out;
        this.addCharge = addCharge;
    }
    public long getDays(){
        StringBuilder sb = new StringBuilder(this.in);
        if(sb.charAt(2) != '/') sb.insert(0, "0");
        if(sb.charAt(5) != '/') sb.insert(3, "0");
        this.in = sb.toString();
        StringBuilder sb2 = new StringBuilder(this.out);
        if(sb2.charAt(2) != '/') sb2.insert(0, "0");
        if(sb2.charAt(5) != '/') sb2.insert(3, "0");
        this.out = sb2.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate a = LocalDate.parse(this.in, formatter);
        LocalDate b = LocalDate.parse(this.out, formatter);
        return ChronoUnit.DAYS.between(a, b) + 1;
    }
    public long getCharge(){
        if(this.room.charAt(0) == '1'){
            return this.getDays() * 25 + this.addCharge;
        }else if(this.room.charAt(0) == '2'){
            return this.getDays() * 34 + this.addCharge;
        }else if(this.room.charAt(0) == '3'){
            return this.getDays() * 50 + this.addCharge;
        }
        return this.getDays() * 80 + this.addCharge;
    }
    public String toString(){
        String[] a = this.name.split("\\s+");
        String res = "";
        for(String x : a){
            res += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length(); i++){
                res += Character.toLowerCase(x.charAt(i));
            }
            res += " ";
        }
        this.name = res.trim();
        return this.ID + " " + this.name + " " + this.room + " " + this.getDays() + " " + this.getCharge();
    }
    @Override
    public int compareTo(Customer other){
        if(this.getCharge() > other.getCharge()) return -1;
        return 1;
    }
}
public class Solution {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("KHACHHANG.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Customer> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Customer a = new Customer(i, br.readLine().trim(), br.readLine().trim(), br.readLine().trim(), br.readLine().trim(), Long.parseLong(br.readLine()));
                arr.add(a);
            }
            Collections.sort(arr);
            for(Customer x : arr){
                System.out.println(x);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
