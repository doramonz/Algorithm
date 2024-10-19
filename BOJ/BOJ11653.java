package BOJ;

import java.io.*;

public class BOJ11653 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                sb.append(i + "\n");
                n /= i;
            }
        }
        if(n!=0&&n!=1){
            sb.append(n);
        }
        System.out.println(sb.toString());
    }
}
