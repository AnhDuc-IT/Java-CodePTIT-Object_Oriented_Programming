import java.util.*;
class Employee{
    private String ID, name, position;
    private long salary, day;
    public Employee(int ID, String name, String position, long salary, long day){
        this.ID = "NV" + String.format("%02d", ID);
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.day = day;
    }
    public int getPos(){
        if(this.position.equals("GD")) return 500;
        if(this.position.equals("PGD")) return 400;
        if(this.position.equals("TP")) return 300;
        if(this.position.equals("KT")) return 250;
        return 100;
    }
    public long getSalary(){
        return this.salary * this.day;
    }
    public long getTemp(){
        double res = 1.0 * (this.getSalary() + this.getPos()) * 2.0 / 3.0;
        long ans = Math.round(res / 1000.0) * 1000;
        if(ans < 25000){
            return ans;
        }
        return 25000;
    }
    public long getAns(){
        return this.getSalary() + this.getPos() - this.getTemp();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getPos() + " " + this.getSalary() + " " + this.getTemp() + " " + this.getAns();
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Employee> arr = new ArrayList<>();
        for(int i = 1; i <= n ;i++){
            sc.nextLine();
            Employee temp = new Employee(i, sc.nextLine(), sc.nextLine(), sc.nextLong(), sc.nextLong());
            arr.add(temp);
        }
        for(Employee x : arr){
            System.out.println(x);
        }
    }
}
