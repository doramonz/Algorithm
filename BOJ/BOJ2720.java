package BOJ;

import java.util.*;

public class BOJ2720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        
       for(int i=0;i<n;i++){
           System.out.print(arr[i]/25+" ");
           arr[i]%=25;
           System.out.print(arr[i]/10+" ");
           arr[i]%=10;
           System.out.print(arr[i]/5+" ");
           arr[i]%=5;
           System.out.println(arr[i]/1);
       }
       scanner.close();
    }
}