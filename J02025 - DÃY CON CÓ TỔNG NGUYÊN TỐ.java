import java.util.*;
public class Solution {
    static int n;
    static int[] a = new int[15];
    static ArrayList<Integer> res = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static boolean Prime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return n > 1;
    }
    static void Try(int i) {
        for (int j = i; j < n; j++) {
            res.add(a[j]);
            int total = 0;
            for (int x : res) total += x;
            if (Prime(total)){
                arr.add(new ArrayList<>(res));
            }
            Try(j + 1);
            res.remove(res.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a, 0, n);
            for (int i = 0; i < n / 2; i++) {
                int tmp = a[i];
                a[i] = a[n - 1 - i];
                a[n - 1 - i] = tmp;
            }
            arr.clear();
            res.clear();
            Try(0);
            Collections.sort(arr, new Comparator<ArrayList <Integer>>() {
                @Override
                public int compare(ArrayList<Integer> o1, ArrayList <Integer> o2){
                    int len = Math.min(o1.size(), o2.size());
                    for(int i = 0; i < len; i++){
                        if(!o1.get(i).equals(o2.get(i))){
                            return o1.get(i) - o2.get(i);
                        }
                    }
                    return o1.size() - o2.size();
                }
            });
            for (ArrayList<Integer> sub : arr) {
                for (int val : sub) System.out.print(val + " ");
                System.out.println();
            }
        }
        sc.close();
    }
}
