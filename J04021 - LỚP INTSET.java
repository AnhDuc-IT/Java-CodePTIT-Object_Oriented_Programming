import java.util.*;
class IntSet{
    private TreeSet <Integer> set = new TreeSet<>();
    public IntSet(int a[]){
        for(int i = 0; i < a.length; i++){
            set.add(a[i]);
        }
    }
    public IntSet(){}
    public IntSet union(IntSet b){
        IntSet temp = new IntSet();
        for(int x : this.set){
            temp.add(x);
        }
        for(int x : b.set){
            temp.add(x);
        }
        return temp;
    }
    private void add(int x) {
        this.set.add(x);
    }
    public String toString(){
        String res = "";
        for(int x : this.set){
            res += x + " ";
        }
        return res;
    }
}
public class Solution {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
public static void main2334547(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }

}
