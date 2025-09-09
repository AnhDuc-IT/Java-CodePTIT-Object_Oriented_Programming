import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Student implements Comparable<Student>{
    private String ID, name, nation;
    private int area;
    private double score;

    public Student(int ID, String name, double score, String nation, int area){
        this.ID = "TS" + String.format("%02d", ID);
        this.name = name;
        this.score = score;
        this.nation = nation;
        this.area = area;
    }

    public void setName(){
        String[] a = this.name.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String x : a){
            res.append(Character.toUpperCase(x.charAt(0)));
            for(int i = 1; i < x.length(); i++){
                res.append(Character.toLowerCase(x.charAt(i)));
            }
            res.append(" ");
        }
        this.name = res.toString().trim();
    }
 
    public double getAddScore(){
        double bonus = 0;
        if(!this.nation.equals("Kinh")) bonus += 1.5;
        if(this.area == 1) bonus += 1.5;
        else if(this.area == 2) bonus += 1.0;
        return bonus;
    }

    public double getTotalScore(){
        return this.score + this.getAddScore();
    }

    public String getResult(){
        if(this.getTotalScore() >= 20.5) return "Do";
        return "Truot";
    }

    @Override
    public String toString(){
        return this.ID + " " + this.name + " " 
               + String.format("%.1f", this.getTotalScore()) + " " 
               + this.getResult();
    }

    @Override
    public int compareTo(Student other){
        if (this.getTotalScore() == other.getTotalScore()) {
            return this.ID.compareTo(other.ID);
        }
        else{
            if(this.getTotalScore() > other.getTotalScore()) return -1;
            return 1;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int n = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            String name = sc.nextLine();
            double score = sc.nextDouble();
            sc.nextLine();
            String nation = sc.nextLine();
            int area = sc.nextInt();
            Student st = new Student(i, name, score, nation, area);
            st.setName();
            arr.add(st);
        }
        Collections.sort(arr);
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
