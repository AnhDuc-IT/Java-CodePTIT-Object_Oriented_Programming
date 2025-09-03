import java.util.*;

class HocBong {
    private String name;
    private double GPA;
    private int DRL;

    public HocBong(String name, double GPA, int DRL){
        this.name = name;
        this.GPA = GPA;
        this.DRL = DRL;
    }

    public String getHocBong(){
        if(this.GPA >= 3.6 && this.DRL >= 90) return "XUATSAC";
        if(this.GPA >= 3.2 && this.DRL >= 80) return "GIOI";
        if(this.GPA >= 2.5 && this.DRL >= 70) return "KHA";
        return "KHONG";
    }

    public boolean check(){
        return !getHocBong().equals("KHONG");
    }

    public double getGPA(){ return this.GPA; }
    public int getDRL(){ return this.DRL; }
    public String getName(){ return this.name; }

    @Override
    public String toString(){
        return this.name + ": " + getHocBong();
    }
}

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();

        ArrayList<HocBong> arr = new ArrayList<>();
        ArrayList<HocBong> arr2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            String name = sc.nextLine();
            double gpa = sc.nextDouble();
            int drl = sc.nextInt();
            sc.nextLine();
            HocBong a = new HocBong(name, gpa, drl);
            arr.add(a);
            arr2.add(a);
        }

        // Sắp xếp theo GPA giảm dần, DRL giảm dần
        Collections.sort(arr, new Comparator<HocBong>(){
            @Override
            public int compare(HocBong o1, HocBong o2){
                int cmp = Double.compare(o2.getGPA(), o1.getGPA());
                if(cmp != 0) return cmp;
                return Integer.compare(o2.getDRL(), o1.getDRL());
            }
        });

        // Xác định số sinh viên được học bổng
        Set<String> hocBongSet = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr.get(i).check()){
                ++count;
                hocBongSet.add(arr.get(i).getName());
                if(count == m){
                    double lastGPA = arr.get(i).getGPA();
                    int j = i+1;
                    while(j<n && arr.get(j).check() && Double.compare(arr.get(j).getGPA(), lastGPA)==0){
                        hocBongSet.add(arr.get(j).getName());
                        ++count;
                        ++j;
                    }
                    break;
                }
            }
        }

        // In kết quả theo thứ tự input
        for(HocBong h: arr2){
            if(hocBongSet.contains(h.getName())){
                System.out.println(h);
            } else {
                System.out.println(h.getName() + ": KHONG");
            }
        }
    }
}
