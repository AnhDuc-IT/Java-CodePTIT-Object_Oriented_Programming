import java.util.*;
public class Solution {
    static class student {
        String code, name, method, mail;
        public student(String c, String n, String m, String em) {
            code = c;
            name = n;
            method = m;
            mail = em;
        }
        public String toString() {
            return code + " " + name + ' ' + method + " " + mail;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<student> a = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            a.add(new student(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        }
        int q = sc.nextInt();
        while(q-->0){
            String cl = sc.next();
            System.out.printf("DANH SACH SINH VIEN KHOA %s:\n", cl);
            a.forEach(e -> {
                if(e.method.substring(1, 3).compareTo(cl.substring(2)) == 0) System.out.println(e);
            });
        }
    }
}
