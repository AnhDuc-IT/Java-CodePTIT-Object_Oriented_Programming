import java.util.*;
public class Solution {
    static int n, k;
    static int[] a = new int[15];
    static ArrayList<Integer> res = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static void Try(int i) {
        for (int j = i; j < n; j++) {
            if((!res.isEmpty() && a[j] > res.get(res.size() - 1)) || res.isEmpty()){
                res.add(a[j]);
                if(res.size() == k){
                    arr.add(new ArrayList<>(res));
                }
            }
            Try(j + 1);
            res.remove(res.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt(); k = sc.nextInt();
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Arrays.sort(a, 0, n);
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
