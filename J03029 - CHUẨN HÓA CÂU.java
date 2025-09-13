import java.io.*;
import java.util.*;
public class Solution{
    static String change(String s){
        String res = "";
        res += Character.toUpperCase(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            res += Character.toLowerCase(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            arr.add(line);
        }
        boolean check = true;
        for(String x : arr){
            String[] line = x.trim().split("\\s+");
            for(int i = 0; i < line.length; i++){
                char temp = line[i].charAt(line[i].length() - 1);
                boolean end = (temp == '.' || temp == '?' || temp == '!' || i == line.length - 1);
                if(check){
                    if(!line[i].isEmpty()){
                        sb.append(change(line[i]));
                    }
                    check = false;
                }else{
                    if(!line[i].equals("?") && !line[i].equals("!") && !line[i].equals(".")){
                        sb.append(" ").append(line[i].toLowerCase());
                    }else{
                        sb.append(line[i].toLowerCase()).append("\n");
                        check = true;
                        continue;
                    }
                }
                if(end){
                    if(temp != '.' && temp != '?' && temp != '!'){
                        sb.append(".").append("\n");
                    }else{
                        sb.append("\n");
                    }
                    check = true;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
