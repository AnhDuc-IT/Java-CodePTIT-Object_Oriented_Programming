import java.util.*;
class Employee{
    private String ID, name, sex, birth, adress, taxcode, date;
    public Employee(String name, String sex, String birth, String adress, String taxcode, String date){
        this.ID = "00001";
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.adress = adress;
        this.taxcode = taxcode;
        this.date = date;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.sex + " " +  this.birth + " " + this.adress + " " + this.taxcode + " " + this.date;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Employee a = new Employee(sc.nextLine(),sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
        System.out.println(a);
    }
}
