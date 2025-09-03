import java.lang.reflect.Array;
import java.util.*;
class Salary{
    private String Init;
    public Salary(String Init){
        this.Init = Init;
    }
    public String getCode(){
        return this.Init;
    }
    public String getid(){
        String[] a = this.Init.split(" ");
        return a[0];
    }
    public String getTen(){
        String res = "";
        String[] a = this.Init.split(" ");
        for(int i = 1; i < a.length; i++){
            res += a[i] + " ";
        }
        return res.trim();
    }
}
class Person extends Salary{
    private String ID, name;
    private long salary, cnt;
    public Person(String ID, String name, long salary, long cnt, Salary Init){
        super(Init.getCode());
        this.ID = ID;
        this.name = name;
        this.salary = salary;
        this.cnt = cnt;
    }
    public String getID(){
        return this.ID;
    }
    public long getExperience(){
        return Integer.parseInt(this.ID.substring(1, 3));
    }
    public long getCoefficient(){
        char s = this.ID.charAt(0);
        long a = this.getExperience();
        if(s == 'A'){
            if(a >= 1 && a <= 3) return 10;
            else if(a >= 4 && a <= 8) return 12;
            else if(a >= 9 && a <= 15) return 14;
            return 20;
        }
        else if(s == 'B'){
            if(a >= 1 && a <= 3) return 10;
            else if(a >= 4 && a <= 8) return 11;
            else if(a >= 9 && a <= 15) return 13;
            return 16;
        }else if(s == 'C'){
            if(a >= 1 && a <= 3) return 9;
            else if(a >= 4 && a <= 8) return 10;
            else if(a >= 9 && a <= 15) return 12;
            return 14;           
        }else{
            if(a >= 1 && a <= 3) return 8;
            else if(a >= 4 && a <= 8) return 9;
            else if(a >= 9 && a <= 15) return 11;
            return 13;
        }
    }
    public long getSalary(){
        return this.salary * this.cnt * 1000 * this.getCoefficient();
    }
    public String toString(){
        return this.ID + " " + this.name  + " " + this.getSalary();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, Salary> map = new HashMap<>();
        Map <String, String> mp = new HashMap<>();
        for(int i = 1; i <= n; i++){
            Salary a = new Salary(sc.nextLine());
            map.put(a.getid(), a);
            mp.put(a.getid(), a.getTen());
        }
        ArrayList <Person> arr = new ArrayList<>();
        int m = sc.nextInt();
        for(int i = 1; i <= m; i++){
            sc.nextLine();
            String ID = sc.nextLine();
            String name = sc.nextLine();
            long salary = sc.nextLong();
            long cnt = sc.nextLong();
            Person a = new Person(ID, name, salary, cnt, map.get(ID.substring(3, 5)));
            arr.add(a);
        }
        String s = sc.next();
        System.out.println("Bang luong phong " + mp.get(s) + ":");
        for(Person x : arr){
            if(x.getID().substring(3, 5).equals(s)){
                System.out.println(x);
            }
        }
        sc.close();
    }
}
