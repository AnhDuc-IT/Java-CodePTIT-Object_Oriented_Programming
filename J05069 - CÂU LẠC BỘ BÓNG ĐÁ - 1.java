import java.lang.reflect.Array;
import java.util.*;
class Club{
    private String code;
    private String name;
    private int ticket;
    public Club(String code, String name, int ticket){
        this.code = code;
        this.name = name;   
        this.ticket = ticket;
    }
    public String getCode(){
        return this.code;
    }
    public String getName(){
        return this.name;
    }
    public int getTicket(){
        return this.ticket;
    }
}
class Match extends Club{
    private String ID;
    private int person;
    public Match(String ID, int person, Club club){
        super(club.getCode(), club.getName(), club.getTicket());
        this.ID = ID;
        this.person = person;
    }
    public int getPrice(){
        return this.person * this.getTicket();
    }
    public String toString(){
        return this.ID + " " + this.getName() + " " + this.getPrice();
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        Map <String, Club> map = new HashMap<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Club a = new Club(sc.nextLine(), sc.nextLine(), sc.nextInt());
            map.put(a.getCode(), a);
        }
        ArrayList <Match> arr = new ArrayList<>();
        int m = sc.nextInt();
        for(int i = 1; i <= m; i++){
            String ID = sc.next();
            int person = sc.nextInt();
            String temp = ID.substring(1, 3);
            Match x = new Match(ID, person, map.get(temp));
            arr.add(x);
        }
        for(Match x : arr){
            System.out.println(x);
        }
        sc.close();
    }
} 
