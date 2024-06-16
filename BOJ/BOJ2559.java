package BOJ;

import java.util.Scanner;

public class BOJ2559 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,x;
        int[] arr;

        n = scanner.nextInt();
        x = scanner.nextInt();
        arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        int max = 0;

        for(int i = 0;i<x;i++){
            sum+=arr[i];
            max=sum;
        }
        
        for(int i = 0;i<n-x;i++){
            sum-=arr[i];
            sum+=arr[i+x];
            if(sum>max){
                max=sum;
            }
        }
        System.out.println(max);
        scanner.close();
    }
}