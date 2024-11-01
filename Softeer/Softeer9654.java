package Softeer;

import java.io.*;
import java.util.*;

public class Softeer9654 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<2;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            for(int j = s;j<=e;j++){
                int attack = 0;
                
                while(attack<m){
                    if(arr[j][attack]==1){
                        arr[j][attack]=0;
                        break;
                    }
                    attack++;
                }
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j]==1)
                    count++;
            }
        }
        System.out.println(count);
    }
}
