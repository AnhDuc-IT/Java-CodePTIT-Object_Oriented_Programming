
import java.util.*;
class Student{
    private String ID, name, lop;
    private double s1, s2, s3;
    public Student( String ID, String name, String lop, double s1, double s2, double s3){
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    public String getID(){
        return this.ID;
    }
    public String toString(){
        return  this.ID + " " + this.name + " " + this.lop + " " + this.s1 + " " + this.s2 + " " + this.s3;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student temp = new Student(sc.nextLine(),sc.nextLine(), sc.nextLine(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator <Student>(){
            @Override
            public int compare(Student o1, Student o2){
                return o1.getID().compareTo(o2.getID());
            }
        });
        int cnt = 1;
        for(Student x : arr){
            System.out.print(cnt++ + " ");
            System.out.println(x);
        }
    }
}
