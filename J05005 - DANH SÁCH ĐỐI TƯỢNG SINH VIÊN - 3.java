import java.util.*;
class Student{
    private String ID, name, birth, className;
    private double GPA;
    public Student(){
        this.ID = "";
        this.name = "";
        this.birth = "";
        this.className = "";
        this.GPA = 0;
    }
    public void input(Scanner sc, int ID){
        this.ID = "B20DCCN" + String.format("%03d", ID);
        sc.nextLine();
        this.name = sc.nextLine();
        this.className = sc.nextLine();
        this.birth = sc.nextLine();
        this.GPA = sc.nextDouble();
    }
    public void change(){
        StringBuilder sb = new StringBuilder(this.birth);
        if(sb.charAt(2) != '/') sb.insert(0, '0');
        if(sb.charAt(5) != '/') sb.insert(3, '0');
        this.birth = sb.toString();
    }
    public void change2(){
        String newName = "";
        String[] a = this.name.trim().split("\\s+");
        for(String x : a){
            newName += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length(); i++){
                newName += Character.toLowerCase(x.charAt(i));
            }
            newName += " ";
        }
        this.name = newName.trim();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.className + " " + this.birth + " " + String.format("%.2f", this.GPA);
    } 
    public double getGPA(){
        return GPA;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Student temp = new Student();
            temp.input(sc, i);
            temp.change();
            temp.change2();
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator <Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.getGPA() < o2.getGPA()){
                    return 1;
                }
                return -1;
            }
        });
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
