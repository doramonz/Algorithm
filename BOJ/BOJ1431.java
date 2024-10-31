package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1431 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] serials = new String[n];
        for (int i = 0; i < n; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length())
                    return o1.length() > o2.length() ? 1 : -1;
                int sumA = 0;
                int sumB = 0;
                for (int i = 0; i < o1.length(); i++)
                    if (o1.charAt(i) >= 48 && o1.charAt(i) <= 57)
                        sumA += o1.charAt(i)-48;
                for (int i = 0; i < o2.length(); i++)
                    if (o2.charAt(i) >= 48 && o2.charAt(i) <= 57)
                        sumB += o2.charAt(i)-48;
                if (sumA != sumB)
                    return sumA > sumB ? 1 : -1;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) == o2.charAt(i))
                        continue;
                    return o1.charAt(i) > o2.charAt(i) ? 1 : -1;
                }
                return 0;
            }

        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(serials[i] + "\n");
        System.out.println(sb.toString());
    }
}
