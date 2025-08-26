import java.util.*;
class Rectangle{
    private double width, height;
    private String color;
    public Rectangle(){
        this.width = 1;
        this.height = 1;
    }
    public Rectangle(double width, double height, String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public double getWidth(){
        return this.width;
    }
    public void setWidth(double width){
        this.width = width;
    }
    public double getHeight(){
        return this.height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        String res = "";
        res += Character.toUpperCase(color.charAt(0));
        for(int i = 1; i < color.length(); i++){
            res += Character.toLowerCase(color.charAt(i));
        }
        this.color = res;
    }
    public double findArea(){
        return this.height * this.width;
    }
    public double findPerimeter(){
        return 2.0 * (this.height + this.width);
    }
}
public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble(), y = sc.nextDouble();
        String color = sc.next();
        Rectangle a = new Rectangle(x, y, color);
        a.setColor(color);
        if(x <= 0 || y <= 0){
            System.out.println("INVALID");
        }else{
            System.out.printf("%.0f %.0f %s", a.findPerimeter(), a.findArea(), a.getColor() + "\n");
        }
    }
}
