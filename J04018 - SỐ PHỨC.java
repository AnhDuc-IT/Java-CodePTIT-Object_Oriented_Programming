import java.util.*;
class complexNumber{
    private int a, b;
    public complexNumber(){
        this.a = a;
        this.b = b;
    }
    public complexNumber(int a, int b){
        this.a = a;
        this.b = b;
    }
    public complexNumber Total(complexNumber p){
        complexNumber temp = new complexNumber();
        temp.a = this.a + p.a;
        temp.b = this.b + p.b;
        return temp;
    }
    public complexNumber Mul(complexNumber p){
        complexNumber temp = new complexNumber();
        temp.a = this.a * p.a - this.b * p.b;
        temp.b = this.a * p.b + this.b * p.a;
        return temp;
    }
    public String toString(){
        if(this.b < 0){
            return this.a + " - " + -this.b + "i";
        }else{
            return this.a + " + " + this.b + "i";
        }
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            complexNumber x = new complexNumber(sc.nextInt(), sc.nextInt());
            complexNumber y = new complexNumber(sc.nextInt(), sc.nextInt());
            complexNumber z = new complexNumber();
            z = x.Total(y);
            z = z.Mul(x);
            complexNumber d = new complexNumber();
            d = x.Total(y);
            d = d.Mul(d);
            System.out.println(z.toString() + ", " + d.toString());
        }
    }
}
