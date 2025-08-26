import java.util.*;
class Student implements Comparable<Student>{
    private String ID, name, className, email;

    public void input(Scanner sc){
        this.ID = sc.nextLine();
        this.name = sc.nextLine();
        this.className = sc.nextLine();
        this.email = sc.nextLine();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.className + " " + this.email;
    }
    public String getID(){
        return this.ID;
    }
    public String getclassName(){
        return this.className;
    }
    @Override
    public int compareTo(Student other){
        return this.ID.compareTo(other.ID);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <Student> arr = new ArrayList<>();
        while(sc.hasNextLine()){
            Student x = new Student();
            x.input(sc);
            arr.add(x);
        }
        Collections.sort(arr);
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
