import java.util.*;
class Teacher implements Comparable<Teacher>{
    private String ID, name, subject;
    public Teacher(int ID, String name, String subject){
        this.ID = "GV" + String.format("%02d", ID);
        this.name = name;
        this.subject = subject;
    }
    public String getSubject(){
        String[] a = this.subject.split(" ");
        String res = "";
        for(String x : a){
            res += Character.toUpperCase(x.charAt(0));
        }
        return res;
    }
    public String getName(){
        String[] a = this.name.split(" ");
        return a[a.length - 1];
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getSubject();
    }
    @Override
    public int compareTo(Teacher other){
        return this.getName().compareTo(other.getName());
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList <Teacher> arr = new ArrayList<>();
        for(int i = 1; i <= n ;i++){
            Teacher temp = new Teacher(i, sc.nextLine(), sc.nextLine());
            arr.add(temp);
        }
        Collections.sort(arr);
        for(Teacher x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
