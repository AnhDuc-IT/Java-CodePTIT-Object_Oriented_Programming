import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class Solution {
    public static int n, a[] = new int[105];
    public static ArrayList<String> arr = new ArrayList<>();
    public static ArrayList<Integer> temp = new ArrayList<>();
    public static void Try(int pos){
        for(int j = pos; j < n; j++){
            if(temp.isEmpty() || a[j] > temp.get(temp.size() - 1)){
                temp.add(a[j]);
                if(temp.size() >= 2){
                    StringBuilder sb = new StringBuilder();
                    for(int x : temp){
                        sb.append(x).append(" ");
                    }
                    arr.add(sb.toString());
                }
                Try(j + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(new File("DAYSO.in"));
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Try(0);
        Collections.sort(arr);
        for (String x : arr) {
            System.out.println(x);
        }
        sc.close();
    }
}
