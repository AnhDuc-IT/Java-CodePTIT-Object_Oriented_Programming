import java.util.*;
class Person{
    private String name, birth;
    public Person(String name, String birth){
        this.name = name;
        this.birth = birth;
    }
    public String toString(){
        return this.name;
    }
    public String getBirth(){
        String ans = "";
        String[] a = this.birth.split("/");
        for(int i = a.length - 1; i >= 0; i--){
            ans += a[i];
        }
        return ans;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <Person> arr = new ArrayList<>();
        sc.nextLine();
        for(int i = 1; i <= n; i++){
            Person a = new Person(sc.next(), sc.nextLine());
            arr.add(a);
        }
        Collections.sort(arr, new Comparator <Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return o1.getBirth().compareTo(o2.getBirth());
            }
        });
        System.out.println(arr.get(n - 1).toString()+ "\n" + arr.get(0).toString());
    }
}
