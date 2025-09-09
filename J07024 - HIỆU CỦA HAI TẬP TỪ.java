import java.io.IOException;
import java.io.File;
import java.util.*;
class WordSet{
    private Set <String> set = new HashSet<>();
    public WordSet(String namefile) throws IOException{
        set = new HashSet<>();
        Scanner sc = new Scanner(new File(namefile));
        while(sc.hasNext()){
            String line = sc.next().toLowerCase();
            set.add(line);
        }
    }
    public String difference(WordSet other){
        TreeSet <String> res = new TreeSet<>();
        res.addAll(set);
        StringBuilder sb = new StringBuilder();
        for(String x : res){
            if(!other.set.contains(x)){
                sb.append(x).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
public class Solution{
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
    public static void main5370086(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}

