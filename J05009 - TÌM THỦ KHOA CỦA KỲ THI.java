import java.lang.reflect.Array;
import java.util.*;
class Student{
    private String name, birth;
    private int ID;
    private double sc1, sc2, sc3;
    public void input(Scanner sc, int ID){
        sc.nextLine();
        this.ID = ID;
        this.name = sc.nextLine();
        this.birth = sc.nextLine();
        this.sc1 = sc.nextDouble();
        this.sc2 = sc.nextDouble();
        this.sc3 = sc.nextDouble();
    }
    public double getGPA(){
        return this.sc1 + this.sc2 + this.sc3;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.birth + " " + String.format("%.1f", getGPA());
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        double max_ans = 0;
        for(int i = 1; i <= n; i++){
            Student a = new Student();
            a.input(sc, i);
            max_ans = Math.max(max_ans, a.getGPA());
            arr.add(a);
        }
        for(Student x : arr){
            if(x.getGPA() == max_ans){
                System.out.println(x);
            }
        }
    }
}
