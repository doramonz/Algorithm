package BOJ;

import java.io.*;
import java.util.*;

public class BOJ18808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            boolean[][] sticker = new boolean[n][m];
            for (int si = 0; si < sticker.length; si++) {
                st = new StringTokenizer(br.readLine());
                for (int sj = 0; sj < sticker[0].length; sj++) {
                    sticker[si][sj] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }
            for (int j = 0; j < 4; j++) {
                // rotate
                boolean attached = false;
                for (int v = 0; v <= map.length - sticker.length; v++) {
                    // move vertical
                    for (int h = 0; h <= map[0].length - sticker[0].length; h++) {
                        // move horizon
                        for (int hv = 0; hv < sticker.length; hv++) {
                            // compare sticker and map
                            for (int hh = 0; hh < sticker[0].length; hh++) {
                                if (sticker[hv][hh] && map[v + hv][h + hh]) {
                                    hh = Integer.MAX_VALUE - 1;
                                    hv = Integer.MAX_VALUE - 1;
                                    break;
                                }
                                if (hv == sticker.length - 1 && hh == sticker[0].length - 1) {
                                    for (int hhv = 0; hhv < sticker.length; hhv++) {
                                        for (int hhh = 0; hhh < sticker[0].length; hhh++) {
                                            if (sticker[hhv][hhh])
                                                map[v + hhv][h + hhh] = true;
                                        }
                                    }
                                    attached = true;
                                }
                            }
                        }
                        if (attached)
                            break;
                    }
                    if (attached)
                        break;
                }
                if (attached)
                    break;
                boolean[][] temp = new boolean[sticker[0].length][sticker.length];
                for (int si = 0; si < sticker.length; si++) {
                    for (int sj = 0; sj < sticker[0].length; sj++) {
                        temp[sj][temp[0].length - 1 - si] = sticker[si][sj];
                    }
                }
                sticker = temp;
            }
        }
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}
