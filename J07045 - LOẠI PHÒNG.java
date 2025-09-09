import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class LoaiPhong implements Comparable<LoaiPhong>{
    private String ID, name, price, service;
    public LoaiPhong(String s){
        String[] a = s.split(" ");
        this.ID = a[0];
        this.name = a[1];
        this.price = a[2];
        this.service = a[3];
    }
    public String toString(){
        return this.ID + " " + this.name + " " + this.price + " " + this.service;
    }
    @Override
    public int compareTo(LoaiPhong other){
        return this.name.compareTo(other.name);
    }
}
public class Solution{
    public static void main(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
    public static void main2961435(String[] args) throws IOException {
        ArrayList<LoaiPhong> ds = new ArrayList<>();
        Scanner in = new Scanner(new File("PHONG.in"));
        int n = Integer.parseInt(in.nextLine());
        while(n-->0){
            ds.add(new LoaiPhong(in.nextLine()));
        }
        Collections.sort(ds);
        for(LoaiPhong tmp : ds){
            System.out.println(tmp);
        }
    }
}
