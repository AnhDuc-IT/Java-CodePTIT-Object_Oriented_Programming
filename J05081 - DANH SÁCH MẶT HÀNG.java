import java.util.*;
class item{
    private String ID, name, unit;
    private int buy, pass;
    private static int count = 1;
    public void input(Scanner sc){
        ID = "MH" + String.format("%03d", count++);
        sc.nextLine();
        name = sc.nextLine();
        unit = sc.nextLine();
        buy = sc.nextInt();
        pass = sc.nextInt();
    }
    public String toString(){
        return ID + " " + name + " " + unit + " " + buy + " " + pass + " " + (pass - buy);
    }
    public int getProfit(){
        return pass - buy;
    }
    public String getID(){
        return ID;
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList <item> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            item temp = new item();
            temp.input(sc);
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator <item>(){
            @Override
            public int compare(item o1, item o2){
                if(o2.getProfit() != o1.getProfit()){
                    return o2.getProfit() - o1.getProfit();
                }else{
                    return o1.getID().compareTo(o2.getID());
                }
            }
        });
        for(item x : arr){
            System.out.println(x.toString());
        }
    }
}
