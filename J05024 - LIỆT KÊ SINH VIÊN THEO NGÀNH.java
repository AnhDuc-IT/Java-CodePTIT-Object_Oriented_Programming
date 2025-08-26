import java.util.*;
class Student{
    private String ID, name, lop, email;
    public Student(String ID, String name, String lop, String email){
        this.ID = ID;
        this.name = name;
        this.lop = lop;
        this.email = email;
    }
    public String getID(){
        return this.ID;
    }
    public String getLop(){
        return this.lop;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.lop + " " + this.email;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            Student a = new Student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        int q = sc.nextInt();
        sc.nextLine();
        while(q-- >0){
            String s = sc.nextLine();
            System.out.println("DANH SACH SINH VIEN NGANH " + s.toUpperCase() + ":");
            if(s.equalsIgnoreCase("Ke toan")){
                for(Student x : arr){
                    if(x.getID().contains("DCKT")){
                        System.out.println(x);
                    }
                }
            }else if(s.equalsIgnoreCase("Cong nghe thong tin")){
                for(Student x : arr){
                    if(x.getID().contains("DCCN") && x.getLop().charAt(0) != 'E'){
                        System.out.println(x);
                    }
                }
            }else if(s.equalsIgnoreCase("An toan thong tin")){
                for(Student x : arr){
                    if(x.getID().contains("DCAT") && x.getLop().charAt(0) != 'E'){
                        System.out.println(x);
                    }
                }
            }else if(s.equalsIgnoreCase("Vien thong")){
                for(Student x : arr){
                    if(x.getID().contains("DCVT")){
                        System.out.println(x);
                    }
                }
            }else{
                for(Student x : arr){
                    if(x.getID().contains("DCDT")){
                        System.out.println(x);
                    }
                }
            }

        }
    }
} 
