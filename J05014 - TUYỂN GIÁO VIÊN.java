import java.util.*;
class Teacher implements Comparable<Teacher>{
    private String ID, name, admission;
    private double score1, score2;
    public Teacher(int ID, String name, String admission, double score1, double score2){
        this.ID = "GV" + String.format("%02d", ID);
        this.name = name;
        this.admission = admission;
        this.score1 = score1;
        this.score2 = score2;
    }
    public double getPriority(){
        if(this.admission.charAt(1) == '1') return 2;
        else if(this.admission.charAt(1) == '2') return 1.5;
        else if(this.admission.charAt(1) == '3') return 1;
        return 0;
    }
    public double getScore(){
        return this.score1 * 2 + this.score2 + this.getPriority();
    }
    public String getSubject(){
        if(this.admission.charAt(0) == 'A') return "TOAN";
        else if(this.admission.charAt(0) == 'B') return "LY";
        return "HOA";
    }
    public String getResult(){
        if(this.getScore() >= 18) return "TRUNG TUYEN";
        return "LOAI";
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getSubject() + " " + String.format("%.1f", this.getScore()) + " " + this.getResult();
    }
    @Override
    public int compareTo(Teacher other){
        if(this.getScore() > other.getScore()) return -1;
        return 1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Teacher> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Teacher a = new Teacher(i, sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Teacher x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
