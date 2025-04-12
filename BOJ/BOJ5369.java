package BOJ;

import java.io.*;
import java.util.*;

public class BOJ5369 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    static void recur(int index){
        if(index>=arr.length)
            return;
        recur(index*2+1);
        recur(index*2+2);
        sb.append(arr[index]).append("\n");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> treeSet = new TreeSet<>();
        String s;
        while ((s = br.readLine()) != null) {
            treeSet.add(Integer.parseInt(s));
        }
        arr = new int[treeSet.size()];
        int index = 0;
        for(int v : treeSet)
            arr[index++] = v;
        recur(0);
        System.out.println(sb);
    }
}
