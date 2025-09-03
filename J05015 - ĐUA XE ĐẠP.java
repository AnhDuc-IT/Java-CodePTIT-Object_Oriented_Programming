import java.util.*;
class Person implements Comparable<Person>{
    private String ID, name, adress, end;
    public Person(String name, String adress, String end){
        this.name = name;
        this.adress = adress;
        this.end = end;
    }
    public String getID(){
        String res = "";
        String[] a = this.name.split(" ");
        String[] b = this.adress.split(" ");
        for(String x : b){
            res += x.charAt(0);
        }
        for(String x : a){
            res += x.charAt(0);
        }
        return res;
    }
    public String getSpeed(){
        String[] a = this.end.split(":");
        double ans = 0;
        ans += Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
        ans -= 6 * 60;
        ans = Math.round(120.0 * 60 / ans);
        return "" + (int)ans + " Km/h";
    }
    public long getAns(){
        String[] a = this.end.split(":");
        long ans = 0;
        ans += Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
        ans -= 6 * 60;
        return ans;
    }
    public String toString(){
        return this.getID() + " " + this.name + " " + this.adress + " " + this.getSpeed();
    }
    @Override
    public int compareTo(Person other){
        if(this.getAns() > other.getAns()) return 1;
        return -1;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <Person> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            Person a = new Person(sc.nextLine(), sc.nextLine(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr);
        for(Person x : arr){
            System.out.println(x);
        }
        sc.close();
    }
}
