import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Business implements Comparable<Business>{
    private String ID, name;
    private long quantity;
    public Business(String ID, String name, long quantity){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
    }
    @Override
    public int compareTo(Business other){
        return this.ID.compareTo(other.ID);
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.quantity;
    }
}
public class Solution{
    public static void main(String[] args) {
        try {
            File file = new File("DN.in");
            Scanner sc = new Scanner(file);
            int n = sc.nextInt();
            ArrayList <Business> arr = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                sc.nextLine();
                Business a = new Business(sc.nextLine(), sc.nextLine(), sc.nextLong());
                arr.add(a);
            }
            Collections.sort(arr);
            for(Business x : arr){
                System.out.println(x);
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
