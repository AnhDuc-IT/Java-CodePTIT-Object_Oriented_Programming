import java.lang.reflect.Array;
import java.util.*;
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        ArrayList <int[]> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] a = new int[2];
            a[0] = x;
            a[1] = y;
            arr.add(a);
        }
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] > b[0]) return 1;
                return -1;
            }
        });
        int res = arr.get(0)[0] + arr.get(0)[1];
        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i)[0] >= res){
                res = arr.get(i)[0] + arr.get(i)[1];
            }else{
                res = res + arr.get(i)[1];
            }
        }
        System.out.println(res);
    }
}
