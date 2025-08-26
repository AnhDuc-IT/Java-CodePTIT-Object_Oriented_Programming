import java.util.*;
class Fraction{
    private long tu, mau;
    public Fraction(){}
    public Fraction(long tu, long mau){
        this.tu = tu;
        this.mau = mau;
    }
    public Fraction Sum(Fraction other){
        Fraction temp = new Fraction();
        temp.tu = this.tu * other.mau + this.mau * other.tu;
        temp.mau = this.mau * other.mau;
        long k = gcd(temp.tu, temp.mau);
        temp.tu /= k;
        temp.mau /= k;
        return temp;
    }
    public Fraction Mul(Fraction other){
        Fraction temp = new Fraction();
        temp.tu = this.tu * other.tu;
        temp.mau = this.mau * other.mau;
        long k = gcd(temp.tu, temp.mau);
        temp.tu /= k;
        temp.mau /= k;
        return temp;
    }
    public long gcd(long a, long b){
        while(b > 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public String toString(){
        return this.tu + "/" + this.mau;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            Fraction a = new Fraction(sc.nextLong(), sc.nextLong());
            Fraction b = new Fraction(sc.nextLong(), sc.nextLong());
            Fraction c = new Fraction();
            c = a.Sum(b);
            c = c.Mul(c);
            Fraction d = new Fraction();
            d = a.Mul(b);
            d = d.Mul(c);
            System.out.println(c + " " + d);
        }
    }
}
