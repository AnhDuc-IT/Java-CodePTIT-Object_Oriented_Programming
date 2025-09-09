import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt(), m = sc.nextInt(), r = sc.nextInt() - 1;
            int[][] a = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            int[] temp = new int[n];
            for(int i = 0; i < n; i++){
                temp[i] = a[i][r];
            }
            Arrays.sort(temp);
            for(int i = 0; i < n; i++){
                a[i][r] = temp[i];
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m ;j++){
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
