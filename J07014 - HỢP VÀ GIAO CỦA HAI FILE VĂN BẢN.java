import java.io.IOException;
import java.io.File;
import java.util.*;

class WordSet{
    private TreeSet<String> set = new TreeSet<>();
    public WordSet(String filename) throws IOException{
        set = new TreeSet<>();
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNext()){
            String line = sc.next().toLowerCase();
            set.add(line);
        }
    }
    public String union(WordSet other){
        TreeSet <String> res = new TreeSet<>(set);
        res.addAll(other.set);
        StringBuilder sb = new StringBuilder();
        for(String x : res){
            sb.append(x).append(" ");
        }
        return sb.toString().trim();
    }
    public String intersection(WordSet other){
        TreeSet <String> res = new TreeSet<>(set);
        res.retainAll(other.set);
        StringBuilder sb = new StringBuilder();
        for(String x : res){
            sb.append(x).append(" ");
        }
        return sb.toString().trim();
    }
}
public class Solution{
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
    public static void main5706538(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
