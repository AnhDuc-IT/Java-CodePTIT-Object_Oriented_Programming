import java.util.*;
class Time{
    private int hour, minute, second;
    public void inPut(Scanner sc){
        hour = sc.nextInt();
        minute = sc.nextInt();
        second = sc.nextInt();
    }
    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    public String toString(){
        return this.hour + " " + this.minute + " " + this.second;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Time> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Time a = new Time();
            a.inPut(sc);
            arr.add(a);
        }
        Collections.sort(arr, new Comparator <Time>(){
            @Override
            public int compare(Time o1, Time o2){
                int ans = o1.getHour() * 3600 + o1.getMinute() * 60 + o1.getSecond();
                int res = o2.getHour() * 3600 + o2.getMinute() * 60 + o2.getSecond();
                if(ans < res){
                    return -1;
                }
                return 1;
            }
        });
        for(Time x : arr){
            System.out.println(x.toString());
        }
    }
}
