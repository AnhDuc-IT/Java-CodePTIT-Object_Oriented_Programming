import java.util.*;
class Business{
    private String ID, name;
    private int quanlity;
    public Business(String ID, String name, int quanlity){
        this.ID = ID;
        this.name = name;
        this.quanlity = quanlity;
    }
    public int getQuantily(){
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
        ArrayList <Business> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            Business temp = new Business(sc.nextLine(), sc.nextLine(), sc.nextInt());
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator<Business>(){
            @Override
            public int compare(Business o1, Business o2){
                if(o1.getQuantily() == o2.getQuantily()){
                    return o1.getID().compareTo(o2.getID());
                }
                return o2.getQuantily() - o1.getQuantily();
            }
        });
        for(Business x : arr){
            System.out.println(x);
        }
    }
}
