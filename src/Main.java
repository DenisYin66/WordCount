import java.io.*;
import java.util.*;

public class Main {
    static List<Map.Entry<String,Integer>> orderList1;
    static List<Map.Entry<String,Integer>> orderList2;

    public static void main(String[] args) {
       lib test = new lib();
       test.dealFile(args);
       orderList1 = test.sortMap(test.getMap1());
       orderList2 = test.sortMap(test.getMap2());
       test.out("output1.txt",orderList1);
        test.out("output2.txt",orderList2);
    }
}