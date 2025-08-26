import java.util.*;
class Student{
    private String name, lop, ns;
    private double gpa;
    public void input(Scanner sc){
        name = sc.nextLine();
        lop = sc.nextLine();
        ns = sc.nextLine();
        gpa = sc.nextDouble();
        StringBuilder sb = new StringBuilder(ns);
        if(sb.charAt(2) != '/'){
            sb.insert(0, '0');
        }
        if(sb.charAt(5) != '/'){
            sb.insert(3, '0');
        }
        ns = sb.toString();
    }
    public void print(){
        System.out.print(name + " " + lop + " " + ns + " ");
        System.out.printf("%.2f", gpa);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] a = new Student[n];
        for(int i = 0; i < n; i++){
            sc.nextLine();
            a[i] = new Student();
            a[i].input(sc);
        }
        for(int i = 0; i < n; i++){
            System.out.print("B20DCCN");
            if(i <= 8){
                System.out.print("00" + (i + 1) + " ");
            }else{
                System.out.print("0" + (i + 1) + " ");
            }
            a[i].print();
            System.out.println();
        }
    }
}
