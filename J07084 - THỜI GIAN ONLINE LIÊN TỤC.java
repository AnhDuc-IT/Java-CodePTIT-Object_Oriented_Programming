import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
class Student implements Comparable <Student>{
    private String name, st, end;
    public Student(String name, String st, String end){
        this.name = name;
        this.st = st;
        this.end = end;
    }
    public long getTimes(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime a = LocalDateTime.parse(this.st, formatter);
        LocalDateTime b = LocalDateTime.parse(this.end, formatter);
        return ChronoUnit.MINUTES.between(a, b);
    }
    public String toString(){
        return this.name + " " + this.getTimes();
    }
    @Override
    public int compareTo(Student other){
        return (int)(other.getTimes() - this.getTimes());
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        //Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList <Student> arr = new ArrayList<>(); 
        for(int i = 1; i <= n; i++){
            Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Student x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
