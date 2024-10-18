package BOJ;

import java.io.*;

public class BOJ17249 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int left = 0;
        int right = 0;
        int i = 0;
        do {
            if (input.charAt(i) == '@')
                left++;
        } while (input.charAt(i++) != '(');
        do {
            if (input.charAt(i) == '@')
                right++;
        } while (++i < input.length());
        System.out.println(left + " " + right);
    }
}
