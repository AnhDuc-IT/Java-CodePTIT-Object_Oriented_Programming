import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Customer implements Comparable<Customer>{
    private String ID, name, room, start, end;
    public Customer(int ID, String name, String room, String start, String end){
        this.ID = "KH" + String.format("%02d", ID);
        this.name = name;
        this.room = room;
        this.start = start;
        this.end = end;
    }
    public long getDays(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate a = LocalDate.parse(this.start, formatter);
        LocalDate b = LocalDate.parse(this.end, formatter);
        return ChronoUnit.DAYS.between(a, b);
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.room + " " + this.getDays();
    }
    @Override
    public int compareTo(Customer other){
        if(this.getDays() > other.getDays()) return -1;
        return 1;
    }
}
public class Solution {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("KHACH.in"));
            int n = Integer.parseInt(br.readLine());
            ArrayList <Customer> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                Customer a = new Customer(i, br.readLine(), br.readLine(), br.readLine(), br.readLine());
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
