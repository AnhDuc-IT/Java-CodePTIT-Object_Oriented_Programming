import java.io.File;
import java.io.IOException;
import java.util.*;
class Subject{
    private String ID, name, exam;
    public Subject(String ID, String name, String exam){
        this.ID = ID;
        this.name = name;
        this.exam = exam;
    }
    public String getID(){
        return this.ID;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.exam;
    }
}
public class Solution{
    public static void main(String[] args)throws IOException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList <Subject> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Subject a = new Subject(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr, new Comparator <Subject>(){
            @Override
            public int compare(Subject o1, Subject o2){
                return o1.getID().compareTo(o2.getID());
            }
        });
        for(Subject x : arr){
            System.out.println(x);
        }
    }
}
