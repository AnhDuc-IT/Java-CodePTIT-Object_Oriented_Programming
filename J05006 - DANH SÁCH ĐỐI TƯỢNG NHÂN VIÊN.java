import java.util.*;
class Employee{
    private String ID, name, sex, birth, adress, taxCode, date;
    public void inPut(Scanner sc, int ID){
        this.ID = "000" + String.format("%02d", ID);
        this.name = sc.nextLine();
        this.sex = sc.nextLine();
        this.birth = sc.nextLine();
        this.adress = sc.nextLine();
        this.taxCode = sc.nextLine();
        this.date = sc.nextLine();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.sex + " " + this.birth + " " + this.adress + " " + this.taxCode + " " + this.date;
    } 
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Employee> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            Employee temp = new Employee();
            temp.inPut(sc, i);
            arr.add(temp);
        }
        for(Employee x : arr){
            System.out.println(x);
        }
    }
}
