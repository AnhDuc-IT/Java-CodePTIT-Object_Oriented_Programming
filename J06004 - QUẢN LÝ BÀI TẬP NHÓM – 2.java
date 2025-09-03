import java.util.*;
class Student implements Comparable<Student>{
    private String ID, name, phone;
    private int group;
    public Student(String ID, String name, String phone, int group){
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.group = group;
    }
    public String getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public int getGroup(){
        return this.group;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.phone + " " + this.group;
    }
    @Override
    public int compareTo(Student other){
        return this.ID.compareTo(other.ID);
    }
}
class HomeWork{
    private String code;
    private int STT;
    public HomeWork(int STT, String code){
        this.code = code;
        this.STT = STT;
    }
    public int getSTT(){
        return this.STT;
    }
    public String toString(){
        return this.code;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt());
            arr.add(a);
        }
        sc.nextLine();
        Map <Integer, String> map = new HashMap<>();
        for(int i = 1; i <= m; i++){
            String s = sc.nextLine();
            HomeWork a = new HomeWork(i, s);
            map.put(i, s);
        }
        Collections.sort(arr);
        for(Student x : arr){
            System.out.println(x + " " + map.get(x.getGroup()));
        }
        sc.close();
    }
} 
