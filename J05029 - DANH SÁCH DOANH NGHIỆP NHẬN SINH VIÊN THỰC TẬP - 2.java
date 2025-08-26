
import java.util.*;
class Student{
    private String ID, name;
    private int quanlity;
    public Student(String ID, String name, int quanlity){
        this.ID = ID;
        this.name = name;
        this.quanlity = quanlity;
    }
    public int getQuanlity(){
        return this.quanlity;
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.quanlity;
    }
    public String getID(){
        return this.ID;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student x = new Student(sc.nextLine(), sc.nextLine(), sc.nextInt());
            arr.add(x);
        }
        int q = sc.nextInt();
        Collections.sort(arr, new Comparator <Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.getQuanlity() == o2.getQuanlity()){
                    return o1.getID().compareTo(o2.getID());
                }
                return o2.getQuanlity() - o1.getQuanlity();
            }
        });
        while(q -- > 0){
            int a = sc.nextInt(), b = sc.nextInt();
            System.out.println("DANH SACH DOANH NGHIEP NHAN TU " + a + " DEN " + b + " SINH VIEN:");
            for(Student x : arr){
                if(x.getQuanlity() >= a && x.getQuanlity() <= b){
                    System.out.println(x);
                }
            }
        }
    }
}
