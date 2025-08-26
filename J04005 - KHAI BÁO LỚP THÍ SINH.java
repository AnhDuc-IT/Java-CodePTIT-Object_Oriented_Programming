import java.util.*;
class Student{
    private String name, birth;
    private double score1, score2, score3;
    public Student(String name, String birth, double score1, double score2, double score3){
        this.name = name;
        this.birth = birth;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    public String toString(){
        return this.name + " " + this.birth + " " + String.format("%.1f", this.score1 + this.score2 + this.score3);
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
        System.out.println(a);
        sc.close();
    }
}
