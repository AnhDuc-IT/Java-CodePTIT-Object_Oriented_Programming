import java.util.*;
class Student implements Comparable<Student>{
    private String ID, name;
    private double Score;
    private int STT;
    public Student(){}
    public Student(int ID, String name, double Score){
        this.ID = "HS" + String.format("%02d", ID);
        this.name = name;
        this.Score = Score;
        this.STT = 0;
    }
    public void setSTT(int cnt){
        this.STT = cnt;
    }
    public double getScore(){
        return this.Score;
    }
    public String getResult(){
        if(this.Score >= 9) return "Gioi";
        else if(this.Score >= 7) return "Kha";
        else if(this.Score >= 5) return "Trung Binh";
        return "Yeu";
    }
    public String toString(){
        return this.ID + " " + this.name + " " + String.format("%.1f", this.Score) + " " + this.getResult() + " " + this.STT;
    }
    @Override
    public int compareTo(Student other){
        if(this.Score > other.Score) return -1;
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        ArrayList <Student> arr2 = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student a = new Student(i, sc.nextLine(), sc.nextDouble());
            arr.add(a);
            arr2.add(a);
        }
        sc.close();
        int cnt = 1;
        Collections.sort(arr2);
        Map <Double,Integer> map = new HashMap<>();
        for(Student x : arr2){
            map.putIfAbsent(x.getScore(), cnt);
            x.setSTT(map.get(x.getScore()));
            ++cnt;
        }
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
