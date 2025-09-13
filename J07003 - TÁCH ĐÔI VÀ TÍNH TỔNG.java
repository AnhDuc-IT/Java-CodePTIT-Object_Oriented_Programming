import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        String s = sc.nextLine().trim();
        while (s.length() > 1) {
            BigInteger num1 = new BigInteger(s.substring(0, s.length() / 2));
            BigInteger num2 = new BigInteger(s.substring(s.length() / 2));
            BigInteger num3 = num1.add(num2);
            System.out.println(num3);
            s = num3.toString();
        }
    }
}
