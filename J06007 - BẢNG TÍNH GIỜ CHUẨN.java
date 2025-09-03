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
    private double Time;
    private Subject subject;
    private Teacher  teacher;
    public Information(Subject subject, Teacher teacher, double Time){
        this.subject = subject;
        this.teacher = teacher;
        this.Time = Time;
    }
    public double getTime(){
        return this.Time;
    }
    public String toString(){
        return this.teacher.getName() + " " + String.format("%.2f", this.Time);
    }
    public Teacher getTeacher(){
        return this.teacher;
    }
    public Subject getSubject(){
        return this.subject;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(); sc.nextLine();
        Map <String, Subject> map = new HashMap<>();
        for(int i = 1; i <= n ;i++){
            String line = sc.nextLine();
            String[] a = line.split(" ");
            String ID = a[0];
            String nameSubject = "";
            for(int j = 1; j < a.length; j++){
                nameSubject += a[j] + " ";
            }
            nameSubject = nameSubject.trim();
            map.put(ID, new Subject(ID, nameSubject));
        }
        Map <String, Teacher> mp = new HashMap<>();
        int m = sc.nextInt(); sc.nextLine();
        for(int i = 1; i <= m; i++){
            String line = sc.nextLine();
            String[] a = line.split(" ");
            String code = a[0];
            String name = "";
            for(int j = 1; j < a.length; j++){
                name += a[j] + " ";
            }
            name = name.trim();
            mp.put(code, new Teacher(code, name));
        }
        ArrayList <Information> arr = new ArrayList<>();
        int q = sc.nextInt();
        Map <String, Double> mapp = new HashMap<>();
        for(int i = 1; i <= q; i++){
            String code = sc.next();
            String ID = sc.next();
            double Time = sc.nextDouble();
            Information a = new Information(map.get(ID), mp.get(code), Time);
            arr.add(a);
            if(mapp.containsKey(a.getTeacher().getCode())){
                mapp.put(a.getTeacher().getCode(), mapp.get(a.getTeacher().getCode()) + Time);
            }else{
                mapp.put(a.getTeacher().getCode(), Time);
            }
        }
        for(int i = 0; i < arr.size(); i++){
            if(mapp.get(arr.get(i).getTeacher().getCode()) != 0){
                System.out.printf(arr.get(i).getTeacher().getName() + " " + "%.2f\n", mapp.get(arr.get(i).getTeacher().getCode()));
                mapp.put(arr.get(i).getTeacher().getCode(), (double)0);
            }
        }
        sc.close();
    }
}
