import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Subject{
    private String ID, name, quantity, formTheory, formPractice;
    public Subject(String ID, String name, String quantity,  String formTheory, String formPractice){
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.formTheory = formTheory;
        this.formPractice = formPractice;
    }
    public String getFormPractice(){
        return this.formPractice;
    }
    public String getID(){
        return this.ID;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.quantity + " " + this.formTheory + " " + this.formPractice;
    }
}
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        //Scanner sc = new Scanner(System.in);
        ArrayList <Subject> arr = new ArrayList<>();
        int n = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= n; i++){
            Subject a = new Subject(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            if(a.getFormPractice().contains("Truc tuyen") || a.getFormPractice().contains(".ptit.edu.vn")){
                arr.add(a);
            }
        }
        Collections.sort(arr, new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2){
                return o1.getID().compareTo(o2.getID());
            }
        });
        for(Subject x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
