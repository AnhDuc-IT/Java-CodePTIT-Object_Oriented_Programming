import java.util.*;
class Student{
    private String ID;
    private String name;
    private String className;
    private String ns;
    private double GPA;
    Student(){
        this.ID = "";
        this.name = "";
        this.className = "";
        this.ns = "";
        this.GPA = 0;
    }
    public void input(Scanner sc){
        sc.nextLine();
        this.name = sc.nextLine();
        this.className = sc.nextLine();
        this.ns = sc.nextLine();
        this.GPA = sc.nextDouble();
    }
    public void change(){
        StringBuilder sb = new StringBuilder(this.ns);
        if(sb.charAt(2) != '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(5) != '/'){
            sb.insert(3, '0');
        }
        this.ns = sb.toString();
    }
    public void change2(){
        String[] a = this.name.trim().split("\\s+");
        String newName = "";
        for(String x : a){
            newName += Character.toUpperCase(x.charAt(0));
            for(int i = 1; i < x.length(); i++){
                newName += Character.toLowerCase(x.charAt(i));
            }
            newName += " ";
        }
        this.name = newName.toString().trim();
    } 
    public String toString(){
        return this.ID + " " + this.name + " " + this.className + " " + this.ns + " " + String.format("%.2f",this.GPA);
    }
    public void setMs(int ID){
        this.ID = "B20DCCN" + String.format("%03d", ID);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for(int i = 0; i < n; i++){
            Student temp = new Student();
            temp.input(sc);
            temp.setMs(i + 1);
            temp.change();
            temp.change2();
            arr[i] = temp;
        }
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
