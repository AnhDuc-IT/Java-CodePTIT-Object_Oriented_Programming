import java.util.*;
class Student implements Comparable<Student>{
    private String ID, name, lop, email;
    public Student(String ID, String name, String lop, String email){
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.email = email;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.lop + " " + this.email;
    }
    public int compareTo(Student other){
        if(this.lop.equals(other.lop)){
            return this.ID.compareTo(other.ID);
        }
        return this.lop.compareTo(other.lop);
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            Student x = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(x);
        }
        Collections.sort(arr);
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
