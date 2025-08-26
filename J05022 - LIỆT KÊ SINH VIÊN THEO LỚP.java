import java.util.*;
class Student{
    private String ID, name, lop, email;
    public String getLop(){
        return this.lop;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.lop + " " + this.email;
    }
    public Student(String ID, String name, String lop, String email){
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.email = email;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            Student a = new Student(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
            arr.add(a);
        }
        int q = sc.nextInt();
        sc.nextLine();
        while(q-- > 0){
            String s = sc.next();
            System.out.println("DANH SACH SINH VIEN LOP " + s + ":");
            for(Student x : arr){
                if(x.getLop().equals(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
