package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int yoot = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0"))
                    yoot++;
            }
            switch (yoot) {
                case 0:
                    sb.append("E" + " ");
                    break;
                case 1:
                    sb.append("A" + " ");
                    break;
                case 2:
                    sb.append("B" + " ");
                    break;
                case 3:
                    sb.append("C" + " ");
                    break;
                case 4:
                    sb.append("D" + " ");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
