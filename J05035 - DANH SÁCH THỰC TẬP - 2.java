
import java.util.*;
class Intern{
    private int number;
    private String ID, name, lop, email, business;
    public String getBusiness(){
        return this.business;
    }
    public String toString(){
        return this.number + " " + this.ID + " " + this.name + " " + this.lop + " " + this.email + " " + this.business;
    }
    public Intern(int number, String ID, String name, String lop, String email, String business){
        this.number = number;
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.email = email;
        this.business = business;
    }
    public String getID(){
        return this.ID;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Intern> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n ; i++){
            Intern temp = new Intern(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(temp);
        }
        int q = sc.nextInt();
        arr.sort(new Comparator<Intern>() {
            public int compare(Intern o1, Intern o2){
                return o1.getID().compareTo(o2.getID());
            }
        });
        while(q-- > 0){
            String s = sc.next();
            for(Intern x : arr){
                if(x.getBusiness().equals(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
