package BOJ;

import java.io.*;
import java.util.Scanner;

public class BOJ2447 {
    static char[][] map;

    static void recur(int size, int y, int x) {
        if (size == 1) {
            map[y][x] = '*';
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int n = 0; n < newSize; n++) {
                        for (int m = 0; m < newSize; m++) {
                            map[y+newSize+n][x+newSize+m] = ' ';
                        }
                    }
                    continue;
                }
                recur(newSize, y + i * newSize, x + j * newSize);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        scanner.close();
        map = new char[n][n];
        recur(n, 0, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
