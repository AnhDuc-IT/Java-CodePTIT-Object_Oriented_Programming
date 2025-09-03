import java.util.*;
class Student{
    private String ID, name;
    private double score1, score2, score3;
    public Student(String ID, String name, double score1, double score2, double score3){
        this.ID = ID;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    public char getPriority(){
        return this.ID.charAt(2);
    }
    public double getAns(){
        if(this.getPriority() == '1') return 0.5;
        else if(this.getPriority() == '2') return 1.0;
        return 2.5;
    }
    public double getScore(){
        return 2.0 * this.score1 + this.score2 + this.score3;
    }
    public String getResult(){
        double res = this.getScore() + this.getAns();
        if(res >= 24){
            return "TRUNG TUYEN";
        }
        return "TRUOT";
    }
    public String toString(){
        double ans = getScore();
        String sc = "";
        String area = "";
        if(ans == (int)ans){
            sc = "" + (int)ans;
        }else{
            sc = String.format("%.1f", ans);
        }
        double res = getAns();
        if((int)res == res){
            area = "" + (int)res;
        }else{
            area = String.format("%.1f", res);
        }
        return this.ID + " " + this.name + " " + area + " " + sc + " " + this.getResult();
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
            Student x = new Student(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            arr.add(x);
        }
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
