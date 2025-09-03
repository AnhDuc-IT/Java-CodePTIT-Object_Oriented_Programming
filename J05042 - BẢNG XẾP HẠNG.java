import java.util.*;
class Student{
    private String name;
    private int cnt, count;
    public Student(String name, int cnt, int count){
        this.name = name;
        this.cnt = cnt;
        this.count = count;
    }
    public int getCnt(){
        return this.cnt;
    }
    public int getCount(){
        return this.count;
    }
    public String toString(){
        return this.name + " " + this.cnt + " " + this.count;
    }
    public String getName(){
        return this.name;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Student> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Student temp = new Student(sc.nextLine(), sc.nextInt(), sc.nextInt());
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator <Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.getCnt() == o2.getCnt()){
                    if(o2.getCount() == o1.getCount()){
                        return o1.getName().compareTo(o2.getName());
                    }
                    return o1.getCount() - o2.getCount();
                }
                return o2.getCnt() - o1.getCnt();
            }
        });
        for(Student x : arr){
            System.out.println(x);
        }
    }
}
