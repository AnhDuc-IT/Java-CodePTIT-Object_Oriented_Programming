import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Subject{
    private String ID, name, quantity;
    public Subject(String ID, String name, String quantity){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getQuantity(){
        return this.quantity;
    }
}
class Group implements Comparable <Group>{
    private String code, codeSubject, date, time, nameGV, room;
    private Subject subject;
    public Group(int code, String codeSubject, String date, String time, String nameGV, String room, Subject subject){
        this.code = "HP" + String.format("%03d", code);
        this.codeSubject = codeSubject;
        this.date = date;
        this.time = time;
        this.nameGV = nameGV;
        this.room = room;
        this.subject = subject;
    }
    public String getCodeSubject(){
        return this.codeSubject;
    }
    public String toString(){
        return this.code + " " + this.subject.getName() + " " + this.date + " " + this.time + " " + this.room;
    }
    public Subject getSubject(){
        return this.subject;
    }
    public String getNameGV(){
        return this.nameGV;
    }
    @Override
    public int compareTo(Group other){
        int cmp = this.date.compareTo(other.date);
        int cmp2 = this.time.compareTo(other.time);
        if(cmp == 0){
            if(cmp2 == 0){
                return this.nameGV.compareTo(other.nameGV);
            }
            return cmp2;
        }
        return cmp;
    }
}
public class Solution{
    public static void main(String[] args){
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("MONHOC.in"));
            BufferedReader br2 = new BufferedReader(new FileReader("LICHGD.in"));
            Map <String, Subject> map = new HashMap<>();
            int n = Integer.parseInt(br1.readLine());
            for(int i = 1; i <= n; i++){
                Subject a = new Subject(br1.readLine(), br1.readLine(), br1.readLine());
                map.put(a.getID(), a);
            } 
            br1.close();
            int m = Integer.parseInt(br2.readLine());
            ArrayList <Group> arr = new ArrayList<>();
            for(int i = 1; i <= m; i++){
                String codeSubject = br2.readLine();
                String date = br2.readLine();
                String time = br2.readLine();
                String nameGV = br2.readLine();
                String room = br2.readLine();
                Group a = new Group(i, codeSubject, date, time, nameGV, room, map.get(codeSubject));
                arr.add(a);
            }
            Collections.sort(arr);
            String q = br2.readLine();
            System.out.println("LICH GIANG DAY GIANG VIEN " + q + ":");
            for(Group x : arr){
                if(x.getNameGV().equals(q)){
                    System.out.println(x);
                }
            }
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
