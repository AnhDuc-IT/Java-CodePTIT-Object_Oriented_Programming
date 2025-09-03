import java.util.*;
class PayRoll{
    private String information;
    public PayRoll(String information){
        this.information = information;
    }
    public String getInformation(){
        return this.information;
    }
    public String getCode(){
        String[] a = this.information.split(" ");
        return a[0];
    }
    public String getInit(){
        String[] a = this.information.split(" ");
        String res = "";
        for(int i = 1; i < a.length; i++){
            res += a[i] + " ";
        }
        return res.trim();
    }
}
class Person extends PayRoll{
    private String ID, name;
    private long salary, cnt;
    public Person(String ID, String name, long salary, long cnt, PayRoll a){
        super(a.getInformation());
        this.ID = ID;
        this.name = name;
        this.salary = salary;
        this.cnt = cnt;
    }
    public String getID(){
        return this.ID.substring(3, 5);
    }
    public long getCoefficient(){
        char a = this.ID.charAt(0);
        int s = Integer.parseInt(this.ID.substring(1, 3));
        if(a == 'A'){
            if(s <= 3) return 10;
            else if(s <= 8) return 12;
            else if(s <= 15) return 14;
            return 20;
        }else if(a == 'B'){
            if(s <= 3) return 10;
            else if(s <= 8) return 11;
            else if(s <= 15) return 13;
            return 16;
        }else if(a == 'C'){
            if(s <= 3) return 9;
            else if(s <= 8) return 10;
            else if(s <= 15) return 12;
            return 14;
        }else{
            if(s <= 3) return 8;
            else if(s <= 8) return 9;
            else if(s <= 15) return 11;
            return 13;
        }
    }
    public long getSalary(){
        return this.getCoefficient() * this.salary * 1000 * this.cnt;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getInit() + " " + this.getSalary();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, PayRoll> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            PayRoll a = new PayRoll(sc.nextLine());
            map.put(a.getCode(), a);
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
        for(Person x : arr){
            System.out.println(x);
        }
        sc.close();
    }
} 
