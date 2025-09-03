import java.lang.reflect.Array;
import java.util.*;
class Subject implements Comparable<Subject>{
    private String code, name, group, teacher;
    public Subject(String code, String name, String group, String teacher){
        this.code = code;
        this.name = name;
        this.group = group;
        this.teacher = teacher;
    }
    public String getGroup(){
        return this.group;
    }
    public String getTeacher(){
        return this.teacher;
    }
    public String getName(){
        return this.name;
    }
    public String getCode(){
        return this.code;
    }
    public String toString(){
        return this.code + " " + this.name + " " + this.group;
    }
    @Override
    public int compareTo(Subject other){
        if(this.code.equals(other.code)){
            return this.group.compareTo(other.group);
        }
        else{
            return this.code.compareTo(other.code);
        }
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        ArrayList <Subject> arr = new ArrayList<>();
        Map <String, String> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String code = sc.nextLine();
            String name = sc.nextLine();
            String group = sc.nextLine();
            String teacher = sc.nextLine();
            Subject a = new Subject(code, name, group, teacher);
            map.put(code, name);
            arr.add(a);
        }
        Collections.sort(arr);
        int q = sc.nextInt(); sc.nextLine();
        while(q-- > 0){
            String s = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + s + ":");
            for(Subject x : arr){
                if(x.getTeacher().equals(s)){
                    System.out.println(x);
                }
            }
        }
        sc.close();
    }
} 
