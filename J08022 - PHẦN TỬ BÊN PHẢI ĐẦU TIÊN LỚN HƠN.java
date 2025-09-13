import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            int[] res = new int[n];
            Stack <Integer> stack = new Stack<>();
            for(int i = n - 1; i >= 0; i--){
                while(!stack.isEmpty() && stack.peek() <= a[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }
                else{
                    res[i] = stack.peek();
                }
                stack.push(a[i]);
            }
            for(int i = 0; i < n; i++){
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
