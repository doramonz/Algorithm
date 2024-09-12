package BOJ;

import java.util.Scanner;

public class BOJ12852 {

    public static void main(String[] args) {
        int[] routes = new int[1000001];
        int[] routes2 = new int[1000001];
        routes[1] = 0;
        routes[2] = 1;
        routes[3] = 1;
        routes2[2] = 1;
        routes2[3] = 1;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        for (int i = 4; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            if (i % 3 == 0 && routes[i / 3] < min) {
                min = routes[i / 3];
                index = i/3;
            }
            if (i % 2 == 0 && routes[i / 2] < min) {
                min = routes[i / 2];
                index = i/2;
            }
            if (routes[i - 1] < min) {
                min = routes[i - 1];
                index = i-1;
            }
            routes[i] = min + 1;
            routes2[i] = index;
        }

        System.out.println(routes[n]);

        int index = n;
        System.out.print(index+" ");
        while(index!=1){
            System.out.print(routes2[index]);
            if(index!=1)
            System.out.print(" ");
            index = routes2[index];
        }

    }
}