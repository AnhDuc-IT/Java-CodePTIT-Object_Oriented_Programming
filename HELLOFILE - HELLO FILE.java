import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("Hello.txt"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}
