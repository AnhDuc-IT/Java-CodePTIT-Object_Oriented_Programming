import java.util.*;
class Student{
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
        return this.ID + " " + this.name + " " + this.phone;
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
        int q = sc.nextInt();
        while(q-- > 0){
            int s = sc.nextInt();
            System.out.println("DANH SACH NHOM " + s + ":");
            for(Student x : arr){
                if(x.getGroup() == s){
                    System.out.println(x);
                }
            }
            System.out.println("Bai tap dang ky: " + map.get(s));
        }
        sc.close();
    }
}
