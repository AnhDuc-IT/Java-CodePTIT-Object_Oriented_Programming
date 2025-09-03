import java.util.*;
class Subject{
    private String ID, nameSubject;
    public Subject(String ID, String nameSubject){
        this.ID = ID;
        this.nameSubject = nameSubject;
    }
    public String getID(){
        return this.ID;
    }
    public String getNameSubject(){
        return this.nameSubject;
    }

}
class Teacher{
    private String code, name;
    public Teacher(String code, String name){
        this.code = code;
        this.name = name;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
}

class Information{
    private Subject subject;
    private Teacher teacher;
    private double Time;
    public Teacher getTeacher(){
        return this.teacher;
    }
    public Subject getSubject(){
        return this.subject;
    }
    public Information(Subject subject, Teacher teacher, double Time){
        this.subject = subject;
        this.teacher = teacher;
        this.Time = Time;
    }
    public double getTime(){
        return this.Time;
    }
    public String toString(){
        return this.subject.getNameSubject() + " " + this.Time;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, Subject> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String temp = sc.nextLine();
            String[] a = temp.split(" ");
            String ID = a[0];
            String nameSubject = "";
            for(int j = 1; j < a.length; j++){
                nameSubject += a[j] + " ";
            }
            nameSubject = nameSubject.trim();
            Subject b = new Subject(ID, nameSubject);
            map.put(ID, b);
        }
        int m = sc.nextInt(); sc.nextLine();
        Map <String, Teacher> mp = new HashMap<>();
        for(int i = 1; i <= m; i++){
            String temp = sc.nextLine();
            String[] a = temp.split(" ");
            String code = a[0];
            String name = "";
            for(int j = 1; j < a.length; j++){
                name += a[j] + " ";
            }
            name = name.trim();
            mp.put(code, new Teacher(code, name));
        }
        ArrayList <Information> arr = new ArrayList<>();
        Map <String, Information> mapp = new HashMap<>();
        int q = sc.nextInt();
        for(int i = 1; i <= q; i++){
            String ID = sc.next();
            String code = sc.next();
            double Time = sc.nextDouble();
            Information a = new Information(map.get(code), mp.get(ID), Time);
            arr.add(a);
            mapp.put(ID, a);
        }
        String s = sc.next();
        System.out.println("Giang vien: " + mp.get(s).getName());
        double res = 0;
        for(Information x : arr){
            if(x.getTeacher().getCode().equals(s)){
                System.out.println(x.getSubject().getNameSubject() + " " + x.getTime());
                res += x.getTime();
            }
        }
        System.out.print("Tong: ");
        System.out.printf("%.2f", res);
        sc.close();
    }
}
