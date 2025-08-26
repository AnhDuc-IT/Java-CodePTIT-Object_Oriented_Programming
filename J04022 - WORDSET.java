import java.util.*;
class WordSet{
    private TreeSet<String> set = new TreeSet<>();
    public WordSet(String s){
        String[] a = s.split(" ");
        for(String x : a){
            this.set.add(x.toLowerCase());
        }
    }
    public String union(WordSet other){
        TreeSet <String> temp = new TreeSet<>();
        temp.addAll(set);
        for(String x : other.set){
            temp.add(x);
        }
        String ans = "";
        for(String x : temp){
            ans += x + " ";
        }
        return ans.trim();
    }
    public String intersection(WordSet other){
        String ans = "";
        for(String x : other.set){
            if(this.set.contains(x)){
                ans += x + " ";
            }
        }
    return ans.trim();
}
}
public class Solution{
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
public static void main9433477(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
} 

