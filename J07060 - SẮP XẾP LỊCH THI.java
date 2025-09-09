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
    private String ID, name, method;
    public Subject(String ID, String name, String method){
        this.ID = ID;
        this.name = name;
        this.method = method;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
}
class Test{
    private String code, date, time, room;
    public Test(int code, String date, String time, String room){
        this.code = "C" + String.format("%03d", code);
        this.date = date;
        this.time = time;
        this.room = room;
    }
    public String getCode(){
        return this.code;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    public String getRoom(){
        return this.room;
    }
}
class Calendar implements Comparable <Calendar>{
    private Subject subject;
    private Test test;
    private String group, quantity;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Calendar(Subject subject, Test test, String group, String quantity){
        this.subject = subject;
        this.test = test;
        this.group = group;
        this.quantity = quantity;
    }
    public LocalDate getDates(){
        String[] a = this.test.getDate().split("/");
        LocalDate now = LocalDate.of(Integer.parseInt(a[2]), Integer.parseInt(a[1]), Integer.parseInt(a[0]));
        return now;
    }
    public String toString(){
        return this.test.getDate() + " " + this.test.getTime() + " " + this.test.getRoom() + " " + this.subject.getName() + " " + this.group + " " + this.quantity;
    }
    @Override
    public int compareTo(Calendar other){
        int cmp = this.getDates().compareTo(other.getDates());
        int cmpa = this.test.getTime().compareTo(other.test.getTime());
        if(cmp == 0){
            if(cmpa == 0){
                return this.test.getCode().compareTo(other.test.getCode());
            }else{
                return cmpa;
            }
        }else{
            return cmp;
        }
    }
}
public class Solution{
    public static void main(String[] args){
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("MONTHI.in"));
            Map <String, Subject> map = new HashMap<>();
            int n = Integer.parseInt(br1.readLine());
            for(int i = 1; i <= n ;i++){
                Subject a = new Subject(br1.readLine(), br1.readLine(), br1.readLine());
                map.put(a.getID(), a);
            }
            br1.close();;
            BufferedReader br2 = new BufferedReader(new FileReader("CATHI.in"));
            int m = Integer.parseInt(br2.readLine());
            Map <String, Test> mp = new HashMap<>();
            for(int i = 1; i <= m; i++){
                Test a = new Test(i, br2.readLine(), br2.readLine(), br2.readLine());
                mp.put(a.getCode(), a);
            }
            br2.close();
            ArrayList <Calendar> arr = new ArrayList<>();
            BufferedReader br3 = new BufferedReader(new FileReader("LICHTHI.in"));
            int p = Integer.parseInt(br3.readLine());
            for(int i = 1; i <= p; i++){
                String[] a = br3.readLine().split(" ");
                Calendar temp = new Calendar(map.get(a[1]), mp.get(a[0]), a[2], a[3]);
                arr.add(temp);
            }
            Collections.sort(arr);
            for(Calendar x : arr){
                System.out.println(x);
            }
            br3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
