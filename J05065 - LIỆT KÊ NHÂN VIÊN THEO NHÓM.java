import java.lang.reflect.Array;
import java.util.*;
class Employee implements Comparable<Employee>{
    private String General;
    public Employee(String General){
        this.General = General;
    }
    public String getName(){
        String[] a = this.General.split(" ");
        String res = "";
        for(int i = 1; i < a.length; i++){
            res += a[i] + " ";
        }
        return res.trim();
    }
    public String getPos(){
        return this.General.substring(0, 2);
    }
    public String getID(){
        return this.General.substring(4, 7);
    }
    public String getCode(){
        return this.General.substring(2, 4);
    }
    public String toString(){
        return this.getName() + " " + this.getPos() + " " + this.getID() + " " + this.getCode();
    }
    @Override
    public int compareTo(Employee other){
        int a = Integer.parseInt(this.getCode());
        int b = Integer.parseInt(other.getCode());
        if(a == b){
            return this.getID().compareTo(other.getID());
        }
        else{
            if(a > b) return -1;
            return 1;
        }
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList <Employee> arr = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            if(name.substring(0,2).equals("GD") && cnt1 == 0){
                ++cnt1;
                Employee a = new Employee(name);
                arr.add(a);
            }
            else if(name.substring(0, 2).equals("TP") && cnt2 <= 2){
                ++cnt2;
                Employee a = new Employee(name);
                arr.add(a);
            }
            else if(name.substring(0, 2).equals("PP") && cnt3 <= 2){
                ++cnt3;
                Employee a = new Employee(name);
                arr.add(a);
            }
            else{
                String res = "NV";
                res += name.substring(2);
                Employee a = new Employee(res);
                arr.add(a);
            }
        }
        Collections.sort(arr);
        int q = sc.nextInt();
        while(q-- > 0){
            String s = sc.next();
            for(Employee x : arr){
                if(x.getPos().equals(s)){
                    System.out.println(x);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
