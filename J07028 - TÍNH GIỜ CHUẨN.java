import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Subject{
    private String ID, name;
    public Subject(String ID, String name){
        this.ID = ID;
        this.name = name;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
}
class Teacher{
    private String code, nameGV;
    public Teacher(String code, String nameGV){
        this.code = code;
        this.nameGV = nameGV;
    }
    public String getCode(){
        return this.code;
    }
    public String getNameGV(){
        return this.nameGV;
    }
}
class Time{
    private Subject subject;
    private Teacher teacher;
    private double time;
    public Time(double time, Subject subject, Teacher teacher){
        this.time = time;
        this.subject = subject;
        this.teacher = teacher;
    }
    public double getTime(){
        return this.time;
    }
    public String toString(){
        return this.teacher.getNameGV();
    }
    public Teacher getTeacher(){
        return this.teacher;
    }
}
public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new FileReader("MONHOC.in"));
        Map <String, Subject> map = new HashMap<>();
        int n = Integer.parseInt(br1.readLine());
        for(int i = 1; i <= n; i++){
            String[] temp = br1.readLine().split("\\s+");
            String res = "";
            for(int j = 1; j < temp.length; j++){
                res += temp[j] + " ";
            }
            Subject a = new Subject(temp[0], res.trim());
            map.put(a.getID(), a);
        }
        br1.close();
        BufferedReader br2 = new BufferedReader(new FileReader("GIANGVIEN.in"));
        Map <String, Teacher> mp = new HashMap<>();
        int m = Integer.parseInt(br2.readLine());
        for(int i = 1; i <= m; i++){
            String[] temp = br2.readLine().split("\\s+");
            String res = "";
            for(int j = 1; j < temp.length; j++){
                res += temp[j] + " ";
            }
            Teacher a = new Teacher(temp[0], res.trim());
            mp.put(a.getCode(), a);
        }
        br2.close();
        ArrayList <Time> arr = new ArrayList<>();
        BufferedReader br3 = new BufferedReader(new FileReader("GIOCHUAN.in"));
        int p = Integer.parseInt(br3.readLine());
        Map <String, Double> mapp = new HashMap<>();
        for(int i = 1; i <= p; i++){
            String[] a = br3.readLine().split("\\s+");
            Time temp = new Time(Double.parseDouble(a[2]), map.get(a[1]), mp.get(a[0]));
            arr.add(temp);
            if(mapp.containsKey(a[0])){
                mapp.put(a[0], mapp.get(a[0]) + temp.getTime());
            }else{
                mapp.put(a[0], temp.getTime());
            }
        }
        for(Time x : arr){
            if(mapp.get(x.getTeacher().getCode()) != 0){
                System.out.print(x + " ");
                System.out.printf("%.2f\n", mapp.get(x.getTeacher().getCode()));
                mapp.put(x.getTeacher().getCode(), 0.0);
            }
        }
        br3.close();
}
}
