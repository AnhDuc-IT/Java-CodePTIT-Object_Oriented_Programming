import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
class DaThuc{
    private String s;
    public DaThuc(String s){
        this.s = s;
    }
    public DaThuc(){}
    public DaThuc cong(DaThuc other){
        DaThuc temp = new DaThuc();
        StringTokenizer st = new StringTokenizer(this.s, " +");
        ArrayList <String> a = new ArrayList<>();
        while(st.hasMoreTokens()){
            a.add(st.nextToken());
        }
        StringTokenizer stt = new StringTokenizer(other.s, " +");
        ArrayList <String> b = new ArrayList<>();
        while(stt.hasMoreTokens()){
            b.add(stt.nextToken());
        }
        ArrayList <String> ans = new ArrayList<>();
        int i = a.size() - 1, j = b.size() - 1;
        while(i >= 0 && j >= 0){
            int n = a.get(i).length();
            int m = b.get(j).length();
            int pos_n = 0;
            for(int r = n - 1; r >= 0; r--){
                if(!Character.isDigit(a.get(i).charAt(r))){
                    pos_n = r;
                    break;
                }
            }
            int pos_m = 0;
            for(int r = m - 1; r >= 0; r--){
                if(!Character.isDigit(b.get(j).charAt(r))){
                    pos_m = r;
                    break;
                }
            }
            int sta = 0, sta2 = 0;
            for(int l = 0; l < n; l++){
                if(!Character.isDigit(a.get(i).charAt(l))){
                    sta = l;
                    break;
                }
            }
            for(int l = 0; l < m; l++){
                if(!Character.isDigit(b.get(j).charAt(l))){
                    sta2 = l;
                    break;
                }
            }
            if(a.get(i).substring(pos_n + 1, n).compareTo(b.get(j).substring(pos_m + 1, m)) == 0){
                Integer res = Integer.parseInt(a.get(i).substring(0, sta)) + Integer.parseInt(b.get(j).substring(0, sta2));
                ans.add("" + res + "*x^" + a.get(i).substring(pos_n + 1));
                --i;
                --j;
            }
            else if(Integer.parseInt(a.get(i).substring(pos_n + 1, n)) < Integer.parseInt(b.get(j).substring(pos_m + 1, m))){
                ans.add("" + a.get(i));
                --i;
            }else{
                ans.add("" + b.get(j));
                --j;
            }
        }
        while(i >= 0){
            ans.add(a.get(i));
            --i;
        }
        while(j >= 0){
            ans.add(b.get(j));
            --j;
        }
        String res = "";
        for(int k = ans.size() - 1; k >= 0; k--){
            res += ans.get(k);
            if(k != 0){
                res += " + ";
            }
        }
        temp.s = res;
        return temp;
    }
    public String toString(){
        return this.s;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
    public static void main3796521(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
    public static void main7603455(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}
