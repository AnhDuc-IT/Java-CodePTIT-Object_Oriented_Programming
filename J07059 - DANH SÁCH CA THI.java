import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Test implements Comparable<Test>{
    private String ID, date, time, room;
    public Test(int ID, String date, String time, String room){
        this.ID = "C" + String.format("%03d", ID);
        this.date = date;
        this.time = time;
        this.room = room;
    }
    public int getTime(){
        String[] a = this.time.split(":");
        return Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
    }
    public int getDate(){
        String[] a = this.date.split("/");
        String res = "";
        for(String x : a){
            res += x;
        }
        return Integer.parseInt(res);
    }
    @Override
    public int compareTo(Test other){
        if(this.getDate() != other.getDate()){
            return this.getDate() - other.getDate();
        }
        if(this.getTime() != other.getTime()){
            return this.getTime() - other.getTime();
        }
        return this.ID.compareTo(other.ID);
    }
    public String toString(){
        return this.ID + " " + this.date + " " + this.time + " " + this.room;
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("CATHI.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList <Test> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Test a = new Test(i, sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Test a : arr){
            System.out.println(a);
        }
        sc.close();
    }
}
