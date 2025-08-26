
import java.util.*;
class Teacher{
    private String ID, name, subject;
    public Teacher(int ID, String name, String subject){
        this.ID = "GV" + String.format("%02d", ID);
        this.name = name;
        this.subject = subject;
    }
    public String getName(){
        return this.name;
    }
    public String getSubject(){
        return this.subject;
    }
    public  String change(){
        String ans = "";
        String[] a = this.subject.split(" ");
        for(String x : a){
            ans += Character.toUpperCase(x.charAt(0));
        }
        return ans;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.change();
    }
}
public class Solution{
    public static String Change(String s){
        String ans = "";
        String[] a = s.split(" ");
        for(String x : a){
            ans += Character.toUpperCase(x.charAt(0));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Teacher> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n ;i++){
            Teacher temp = new Teacher(i, sc.nextLine(),sc.nextLine());
            arr.add(temp);
        }
        int q = sc.nextInt();
        sc.nextLine();
        while(q-- > 0){
            String s = sc.nextLine();
            System.out.println("DANH SACH GIANG VIEN BO MON " + Change(s) + ":");
            for(Teacher x : arr){
                if(x.getSubject().equals(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
