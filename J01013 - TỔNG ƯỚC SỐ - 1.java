import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 2000000;
    static int[] F = new int[MAX + 1];

    public static void sieve() {
        for (int i = 2; i <= MAX; i++) F[i] = i;
        for (int i = 2; i * i <= MAX; i++) {
            if (F[i] == i) {
                for (int j = i * i; j <= MAX; j += i) {
                    if (F[j] == j) F[j] = i;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sieve();
        long total = 0;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            while (x > 1) {
                total += F[x];
                x /= F[x];
            }
        }

        System.out.println(total);
    }
}
