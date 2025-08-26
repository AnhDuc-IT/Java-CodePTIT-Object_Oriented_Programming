import java.util.*;
class Person{
    private String ID, name, in, out;
    public Person(String ID, String name, String in, String out){
        this.ID = ID;
        this.name = name;
        this.in = in;
        this.out = out;
    }
    public String getIn(){
        return this.in;
    }
    public String getOut(){
        return this.out;
    }
    public long getResult(){
        String h_in = getIn().substring(0, 2);
        String m_in = getIn().substring(3, 5);
        String h_out = getOut().substring(0, 2);
        String m_out = getOut().substring(3, 5);
        long res = 1l * (Integer.parseInt(h_out) - Integer.parseInt(h_in)) * 60 + (Integer.parseInt(m_out) - Integer.parseInt(m_in));
        return res;
    }
    public String getAns(){
        String ans = "";
        long res = getResult();
        ans += "" + (int)res / 60 + " gio ";
        ans += "" + res % 60 + " phut ";
        return ans;
    }
    public String toString(){
        return this.ID + "  " + this.name + " " + this.getAns();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList <Person> arr = new ArrayList<>();
        for(int i = 1; i <= n ;i++){
            Person a= new Person(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr, new Comparator <Person>(){
            @Override
            public int compare(Person o1, Person o2){
                if(o1.getResult() > o2.getResult()){
                    return -1;
                }
                return 1;
            }
        });
        for(Person x : arr){
            System.out.println(x);
        }
    }
}
