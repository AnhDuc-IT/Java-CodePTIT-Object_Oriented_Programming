import java.util.*;
class Student implements Comparable<Student>{
    private String ID, name;
    private double score1, score2, score3;
    public Student(String ID, String name, double score1, double score2, double score3){
        this.ID = ID;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    public double getPriority(){
        if(this.ID.charAt(2) == '1') return 0.5;
        else if(this.ID.charAt(2) == '2') return 1;
        return 2.5;
    }
    public double getScore(){
        return this.score1 * 2 + this.score2 + this.score3 + this.getPriority();
    }
    public String toString(){
        double ans = this.getPriority();
        double Score = this.getScore();
        if((int)ans == ans){
            if((int)Score == Score){
                return this.ID + " " + this.name + " " + (int)this.getPriority() + " " + (int)this.getScore();
            }else{
                return this.ID + " " + this.name + " " + (int)this.getPriority() + " " + String.format("%.1f", Score);
            }
        }else{
            if((int)Score == Score){
                return this.ID + " " + this.name + " " + String.format("%.1f", ans) + " " + (int)Score;
            }else{
                return this.ID + " " + this.name + " " + String.format("%.1f", ans) + " " + String.format("%.1f", Score);
            }
        }
    }
    @Override   
    public int compareTo(Student other){
        if(this.getScore() == other.getScore()){
            return this.ID.compareTo(other.ID);
        }else{
            if(this.getScore() > other.getScore()) return -1;
            return 1;
        }
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            arr.add(a);
        }
        Collections.sort(arr);
        int q = sc.nextInt();
        double ans = 0;
        int cnt = 0;
        for(Student x : arr){
            ++cnt;
            if(cnt == q){
                ans = x.getScore();
                System.out.println(x.getScore());
                break;
            }
        }
        for(Student x : arr){
            if(x.getScore() >= ans){
                System.out.println(x + " " + "TRUNG TUYEN");
            }else{
                System.out.println(x + " " + "TRUOT");
            }
        }
        sc.close();
    }
} 
