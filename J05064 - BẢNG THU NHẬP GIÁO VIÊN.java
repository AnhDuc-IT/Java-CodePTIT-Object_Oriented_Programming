import java.util.*;
class Teacher{
    private String ID, name;
    private long salary;
    public Teacher(String ID, String name, long salary){
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }
    public String getID(){
        return this.ID.substring(0, 2);
    }
    public int getPos(){
        return Integer.parseInt(this.ID.substring(2, 4));
    }
    public long getGift(){
        if(this.getID().equals("HT")) return 2000000;
        else if(this.getID().equals("HP")) return 900000;
        return 500000;
    }
    public long getTotal(){
        return 1l * this.salary * this.getPos() + this.getGift();
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.getPos() + " " + this.getGift() + " " + getTotal();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        int cnt = 0, dem = 0;
        ArrayList <Teacher> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Teacher a = new Teacher(sc.nextLine(), sc.nextLine(), sc.nextLong());
            arr.add(a);
        }
        for(Teacher x : arr){
            if(x.getID().equals("HT")){
                if(cnt < 1){
                    System.out.println(x);
                    ++cnt;
                }
            }
            else if(x.getID().equals("HP")){
                if(dem <= 1){
                    System.out.println(x);
                    ++dem;
                }
            }else{
                System.out.println(x);
            }
        }
    }
}
