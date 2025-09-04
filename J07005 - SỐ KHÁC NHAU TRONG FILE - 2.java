import java.util.*;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < 100000; i++){
            int temp = dis.readInt();
            if(map.get(temp) == null) map.put(temp, 1);
            else map.put(temp, map.get(temp) + 1);
        }
        map.forEach((u, v) -> System.out.println(u + " " + v));
        dis.close();
    }
}
