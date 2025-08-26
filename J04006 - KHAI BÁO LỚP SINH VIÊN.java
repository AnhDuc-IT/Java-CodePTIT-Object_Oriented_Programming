import java.util.*;
class Student{
    private String ID, name, className, birth;
    private double GPA;
    public Student(String name, String className, String birth, double GPA){
        this.ID = "B20DCCN001";
        this.name = name;
        this.className = className;
        this.birth = birth;
        this.GPA = GPA;
    }
    public void setBirth(){
        StringBuilder sb = new StringBuilder(this.birth);
        if(sb.charAt(2) != '/'){
            sb.insert(0, "0");
        }
        if(sb.charAt(5) != '/'){
            sb.insert(3, "0");
        }
        this.birth = sb.toString();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.className + " " + this.birth + " " + String.format( "%.2f", this.GPA);
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextDouble());
        a.setBirth();
        System.out.println(a);
        sc.close();
    }
}
