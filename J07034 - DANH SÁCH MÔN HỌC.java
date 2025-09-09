import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Subject implements Comparable<Subject>{
    private String ID, name;
    private int quantity;
    public Subject(String ID, String name, int quantity){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.quantity;
    }
    @Override
    public int compareTo(Subject other){
        return this.name.compareTo(other.name);
    }
}
public class Solution{
    public static void main(String[] args) {
        try {
            File file = new File("MONHOC.in");
            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            ArrayList <Subject> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                sc.nextLine();
                Subject a = new Subject(sc.nextLine(), sc.nextLine(), sc.nextInt());
                arr.add(a);
            }
            Collections.sort(arr);
            for(Subject x : arr){
                System.out.println(x);
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
