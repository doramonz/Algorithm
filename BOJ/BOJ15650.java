package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15650 {
    static boolean[] used;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    static void recur(int num, int index){
        if(num==m){
            for(int i = 0;i<n;i++){
                if(used[i]){
                    sb.append(i+1).append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for(int j = index;j<n;j++){
            if(used[j])continue;
            used[j] = true;
            recur(num+1, j+1);
            used[j] =false;
        }
    }
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n];
        recur(0, 0);
        System.out.println(sb);
    }    
}
