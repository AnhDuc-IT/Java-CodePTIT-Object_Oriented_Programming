import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.*;
public class Solution {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new FileReader("DATA.in"));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
