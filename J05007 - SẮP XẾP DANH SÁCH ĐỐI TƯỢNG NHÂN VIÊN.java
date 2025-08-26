import java.util.*;
class Employee implements Comparable <Employee>{
    private String ID, name, sex, birth, adress, taxcode, date;
    public Employee(int ID, String name, String sex, String birth, String adress, String taxcode, String date){
        this.ID = String.format("%05d", ID);
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.adress = adress;
        this.taxcode = taxcode;
        this.date = date;
    }
    public String getBirth(){
        String res = "";
        String[] a = this.birth.split("/");
        for(String x : a){
            res = x + res;
        }
        return res;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.sex + " " + this.birth + " " + this.adress + " " + this.taxcode + " " + this.date;
    }
    @Override
    public int compareTo(Employee other){
        return this.getBirth().compareTo(other.getBirth());
    }
}
public class Solution{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Employee> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            Employee a = new Employee(i, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Employee x : arr){
            System.out.println(x);
        }
    }
}
