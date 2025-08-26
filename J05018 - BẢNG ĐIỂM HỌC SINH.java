import java.util.*;
class Student implements Comparable<Student>{
    private String ID, name;
    double s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    public void input(Scanner sc, int ID){
        this.ID = "HS" + String.format("%02d", ID);
        sc.nextLine();
        this.name = sc.nextLine();
        this.s1 = sc.nextDouble();
        this.s2 = sc.nextDouble();
        this.s3 = sc.nextDouble();
        this.s4 = sc.nextDouble();
        this.s5 = sc.nextDouble();
        this.s6 = sc.nextDouble();
        this.s7 = sc.nextDouble();
        this.s8 = sc.nextDouble();
        this.s9 = sc.nextDouble();
        this.s10 = sc.nextDouble();
    }
    public double getScore(){
        double ans = (s1 * 2 + 2 * s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10) / 12.0;
        return ans;
    }
    public String getAns(){
        double sc = getScore();
        if(sc >= 9) return "XUAT SAC";
        else if(sc >= 8) return "GIOI";
        else if(sc >= 7) return "KHA";
        else if(sc >= 5) return "TB";
        return "YEU";
    }
    @Override
    public int compareTo(Student other){
        if(this.getScore() == other.getScore()){
            return this.ID.compareTo(other.ID);
        }
        else{
            if(this.getScore() > other.getScore()) return -1;
            return 1;
        }
    }
    public String toString(){
        double ans = Math.round(getScore() * 10.0) / 10.0;
        return this.ID + " " + this.name + " " + String.format("%.1f",ans) + " " + this.getAns();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Student x = new Student();
            x.input(sc, i);
            arr.add(x);
        }
        Collections.sort(arr);
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
