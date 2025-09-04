import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Customer implements Comparable<Customer>{
    private String ID, name, room, in, out;
    private int addCharge;
    public Customer(int ID, String name, String room, String in, String out, int addCharge){
        this.ID = "KH" + String.format("%02d", ID);
        this.name = name;
        this.room = room;
        this.in = in;
        this.out = out;
        this.addCharge = addCharge;
    }
    public long getDays(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate a = LocalDate.parse(this.in, formatter);
        LocalDate b = LocalDate.parse(this.out, formatter);
        return ChronoUnit.DAYS.between(a, b) + 1;
    }
    public long getCharge(){
        char a = this.room.charAt(0);
        if(a == '1') return this.getDays() * 25 + this.addCharge;
        else if(a == '2') return this.getDays() * 34 + this.addCharge;
        else if(a == '3') return this.getDays() * 50 + this.addCharge;
        return this.getDays() * 80 + this.addCharge;
    }
    public String toString(){
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
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Customer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Customer a = new Customer(i, sc.nextLine().trim(), sc.nextLine().trim(), sc.nextLine().trim(), sc.nextLine().trim(), sc.nextInt());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Customer x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
