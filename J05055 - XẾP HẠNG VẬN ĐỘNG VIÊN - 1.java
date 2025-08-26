import java.util.*;
class Athlete implements Comparable<Athlete>{
    private String ID, name, age, start, end;
    private int STT;
    public Athlete(int ID, String name, String age, String start, String end){
        this.ID = "VDV" + String.format("%02d", ID);
        this.name = name;
        this.age = age;
        this.start = start;
        this.end = end;
    }
    public long getTime(){
        long l = 0, r = 0;
        l += Integer.parseInt(this.start.substring(0, 2)) * 3600 + Integer.parseInt(this.start.substring(3, 5)) * 60 + Integer.parseInt(this.start.substring(6, 8));
        r += Integer.parseInt(this.end.substring(0,2)) * 3600 + Integer.parseInt(this.end.substring(3, 5)) * 60 + Integer.parseInt(this.end.substring(6, 8));
        return r - l;
    }
    public String getReal(){
        String ans = "";
        long h = this.getTime() / 3600;
        long m = (this.getTime() - h * 3600) / 60;
        long s = (this.getTime() - h * 3600 - m * 60);
        ans = "" + String.format("%02d", h) + ":" +  String.format("%02d", m) + ":" + String.format("%02d", s);
        return ans;
    }
    public int getAdd(){
        int temp = 2021 - Integer.parseInt(this.age.substring(6));
        if(temp >= 32) return 3;
        else if(temp >= 25) return 2;
        else if(temp >= 18) return 1;
        return 0;
    }
    public String getPriority(){
        return "00:00:" + String.format("%02d", this.getAdd());
    }
    public String getAns(){
        long temp = this.getTime() - this.getAdd();
        String ans = "";
        long h = temp / 3600;
        long m = (temp - h * 3600) / 60;
        long s = (temp - h * 3600 - m * 60);
        ans = "" + String.format("%02d", h) + ":" +  String.format("%02d", m) + ":" + String.format(("%02d"), s);
        return ans;
    }
    public long getScore(){
        return this.getTime() - this.getAdd();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getReal() + " " + this.getPriority() + " " + this.getAns() + " " + this.STT;
    }
    void setSTT(int cnt){
        this.STT = cnt;
    }
    @Override
    public int compareTo(Athlete other){
        if(this.getScore() < other.getScore()){
            return -1;
        }
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList <Athlete> arr = new ArrayList<>();
        ArrayList <Athlete> arr2 = new ArrayList<>();
        HashMap <Long, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            Athlete temp = new Athlete(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(temp);
            arr2.add(temp);
        }
        int cnt = 1;
        Collections.sort(arr2);
        for(Athlete x : arr2){
            if(map.containsKey(x.getScore())){
                x.setSTT(map.get(x.getScore()));
            }else{
                map.put(x.getScore(), cnt);
                x.setSTT(cnt);
            }
            ++cnt;
        }
        for(Athlete x : arr){
            System.out.println(x);
        }
    }
}
