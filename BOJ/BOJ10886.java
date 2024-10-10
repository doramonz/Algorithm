package BOJ;

import java.io.*;

public class BOJ10886 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int no = 0, yes = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(br.readLine()) == 0) {
                no++;
            } else {
                yes++;
            }
        }
        System.out.println(no > yes ? "Junhee is not cute!" : "Junhee is cute!");
    }
}
