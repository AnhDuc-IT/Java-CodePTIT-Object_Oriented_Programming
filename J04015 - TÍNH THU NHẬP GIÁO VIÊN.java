import java.util.*;
class Teacher{
    private String ms, name;
    private long coins;
    public void input(Scanner sc){
        ms = sc.nextLine();
        name = sc.nextLine();
        coins = sc.nextLong();
    }
    public void output(){
        System.out.print(ms + " " + name + " ");
        String ans = "";
        for(int i = 2; i < 4; i++){
            ans += ms.charAt(i);
        }
        int temp = Integer.parseInt(ans);
        System.out.print(temp + " ");
        String res = "";
        for(int i = 0; i < 2; i++){
            res += ms.charAt(i);
        }
        if(res.equals("HT")){
            System.out.print(2000000 + " ");
            long pro = coins * temp + 2000000;
            System.out.println(pro);
        }else if(res.equals("HP")){
            System.out.print(900000 + " ");
            long pro = coins * temp + 900000;
            System.out.println(pro);
        }else{
            System.out.print(500000 + " ");
            long pro = coins * temp + 500000;
            System.out.println(pro);
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Teacher a = new Teacher();
        a.input(sc);
        a.output();
    }
}
