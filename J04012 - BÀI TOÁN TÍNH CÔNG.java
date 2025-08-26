import java.util.*;
class Employee{
    private String ms, name;
    private long salary;
    private int day;
    private String work;
    public void input(Scanner sc){
        ms = "NV01";
        name = sc.nextLine();
        salary = sc.nextLong();
        day = sc.nextInt();
        work = sc.next();
    }
    public void print(){
        System.out.print(ms + " " + name + " ");
        long ans = salary * day;
        long res = 0;
        if(day >= 25){
            res = (long) (1l * ans * 0.2);
        }else if(day >= 22 && day < 25){
            res = (long) (1l * ans * 0.1);
        }else{
            res = 0;
        }
        long gift = 0;
        if(work.equals("GD")){
            gift = 250000;
        }else if(work.equals("PGD")){
            gift = 200000;
        }else if(work.equals("TP")){
            gift = 180000;
        }else{
            gift = 150000;
        }
        long total = ans + res + gift;
        System.out.println(ans +  " " + res + " " + gift + " " + total);
    }

}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee a = new Employee();
        a.input(sc);
        a.print();
    }
}
