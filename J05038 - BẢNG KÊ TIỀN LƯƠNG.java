import java.util.*;
class Employee{
    private String ID, name;
    private Long Salary, cnt;
    private String positon;
    public Employee(int ID, String name, Long Salary, Long cnt, String poition){
        this.ID = "NV" + String.format("%02d", ID);
        this.name = name;
        this.Salary = Salary;
        this.cnt = cnt;
        this.positon = poition;
    }
    public long getSalary(){
        return this.Salary * cnt;
    }
    public long getAward(){
        if(cnt >= 25){
            return this.getSalary() * 20 / 100;
        }else if(cnt >= 22){
            return this.getSalary() * 10 / 100;
        }
        return 0;
    } 
    public int getPosition(){
        if(this.positon.equals("GD")) return 250000;
        else if(this.positon.equals("PGD")) return 200000;
        else if(this.positon.equals("TP")) return 180000;
        return 150000;
    }
    public long getTotal(){
        return this.getSalary() + this.getAward() + this.getPosition();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getSalary() + " " + this.getAward() + " " + this.getPosition() + " " + this.getTotal();
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long total = 0;
        sc.nextLine();
        ArrayList<Employee> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String name = sc.nextLine();
            long a = sc.nextLong();
            long b = sc.nextLong();
            sc.nextLine();
            String cv = sc.nextLine();
            Employee temp = new Employee(i, name, a, b, cv);
            arr.add(temp);
            total += temp.getTotal();
        }
        for(Employee x : arr){
            System.out.println(x);
        }
        System.out.println("Tong chi phi tien luong: " + total);
    }
}
