import java.util.*;
class Fraction{
    private long numerator, denominator;
    public Fraction(){}
    public Fraction(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public Fraction Sum(Fraction other){
        Fraction temp = new Fraction();
        temp.numerator = this.numerator * other.denominator + this.denominator * other.numerator;
        temp.denominator = this.denominator * other.denominator;
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
    public void Process(){
        long temp = this.gcd(this.numerator, this.denominator);
        this.numerator /= temp;
        this.denominator /= temp;
    }
    public String toString(){
        return this.numerator +  "/" + this.denominator;
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fraction a = new Fraction(sc.nextLong(), sc.nextLong());
        Fraction b = new Fraction(sc.nextLong(), sc.nextLong());
        a = a.Sum(b);
        a.Process();
        System.out.println(a);
        sc.close();
    }
}
