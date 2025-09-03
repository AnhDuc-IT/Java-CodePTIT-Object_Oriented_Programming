import java.lang.reflect.Array;
import java.util.*;
class Student{
    private String ID, name, lop;
    public Student(String ID, String name, String lop){
        this.ID = ID;
        this.lop = lop;
        this.name = name;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getLop(){
        return this.lop;
    }
}
class RollCall extends Student{
    private String code, count;
    public RollCall(String Code, String Count, Student student){
        super(student.getID(), student.getName(), student.getLop());
        this.code = Code;
        this.count = Count;
    }
    public String getScore(){
        int Score = 10;
        for(int i = 0; i < this.count.length(); i++){
            if(this.count.charAt(i) == 'v'){
                Score -= 2;
            }
            else if(this.count.charAt(i) == 'm'){
                Score -= 1;
            }
        }
        if(Score <= 0){
            return "0 KDDK";
        }else{
            return "" + Score;
        }
    }
    public String toString(){
        return this.getID() + " " + this.getName() + " " + this.getLop() + " " + this.getScore();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, Student> map = new HashMap<>();
        ArrayList <String> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine());
            map.put(a.getID(), a);
            arr.add(a.getID());
        }
        Map<String, RollCall> mp = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String code = sc.next();
            String count = sc.next();
            RollCall a = new RollCall(code, count, map.get(code));
            mp.put(code, a);
        }
        for(String x : arr){
            System.out.println(mp.get(x));
        }
        sc.close();
    }
} 
