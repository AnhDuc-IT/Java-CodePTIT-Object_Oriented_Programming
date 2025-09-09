import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Room{
    private String ID, ranking;
    private double price;
    private double charge;
    public Room(String ID, String ranking, double price, double charge){
        this.ID = ID;
        this.ranking = ranking;
        this.price = price;
        this.charge = charge;
    }
    public double getPrice(){
        return this.price;
    }
    public double getCharge(){
        return this.charge;
    }
    public String getID(){
        return this.ID;
    }
}
class Customer implements Comparable <Customer>{
    private String code, name, room, in, out;
    private Room a;
    public Customer(int code, String name, String room, String in, String out, Room a){
        this.code = "KH" + String.format("%02d", code);
        this.name = name;
        this.room = room;
        this.in = in;
        this.out = out;
        this.a = a;
    }
    public long getDays(){
        DateTimeFormatter fomatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate a = LocalDate.parse(this.in, fomatter);
        LocalDate b = LocalDate.parse(this.out, fomatter);
        long temp = ChronoUnit.DAYS.between(a, b);
        return temp;
    }
    public double getDiscount(){
        double a = this.getDays();
        if(a == 0){
            a = 1;
        }
        double temp = a * this.a.getPrice();
        if(a > 30){
            return temp * 0.94 * (1 + this.a.getCharge());
        }else if(a >= 20){
            return temp * 0.96 * (1 + this.a.getCharge());
        }else if(a >= 10){
            return temp * 0.98 * (1 + this.a.getCharge());
        }
        return temp * (1 + this.a.getCharge());
    }
    @Override
    public int compareTo(Customer other){
        if(this.getDays() > other.getDays()) return -1;
        return 1;
    }
    public String toString(){
        return this.code + " " + this.name + " " + this.room + " " + this.getDays() + " " + String.format(
            "%.2f", this.getDiscount());
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("DATA.in");
        Scanner sc = new Scanner(file);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        Map <String, Room> map = new HashMap<>();
        sc.nextLine();
        for(int i = 1; i <= n ;i++){
            String[] line = sc.nextLine().split("\\s+");
            Room a = new Room(line[0], line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]));
            map.put(a.getID(), a);
        }
        int m = sc.nextInt(); sc.nextLine();
        ArrayList <Customer> arr = new ArrayList<>();
        for(int i = 1; i <= m ;i++){
            String name = sc.nextLine().trim();
            String room = sc.nextLine().trim();
            String in = sc.nextLine().trim();
            String out = sc.nextLine().trim();
            Customer a = new Customer(i, name, room, in, out, map.get("" + room.charAt(2)));
            arr.add(a);
        }
        Collections.sort(arr);
        for(Customer x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
