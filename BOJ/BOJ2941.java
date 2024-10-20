package BOJ;

import java.io.*;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String croatia = br.readLine();
        int index = 0;
        int output = 0;
        while (index < croatia.length()) {
            if (croatia.charAt(index) == 'c') {
                if (index + 1 < croatia.length()
                        && (croatia.charAt(index + 1) == '-' || croatia.charAt(index + 1) == '=')) {
                    index += 2;
                } else {
                    index++;
                }
            } else if (croatia.charAt(index) == 'd') {
                if (index + 2 < croatia.length() && croatia.charAt(index + 2) == '='
                        && croatia.charAt(index + 1) == 'z') {
                    index += 3;
                } else if (index + 1 < croatia.length() && croatia.charAt(index + 1) == '-') {
                    index += 2;
                } else {
                    index++;
                }
            } else if (croatia.charAt(index) == 'l') {
                if (index + 1 < croatia.length() && croatia.charAt(index + 1) == 'j') {
                    index += 2;
                } else {
                    index++;
                }
            } else if (croatia.charAt(index) == 'n') {
                if (index + 1 < croatia.length() && croatia.charAt(index + 1) == 'j') {
                    index += 2;
                } else {
                    index++;
                }
            } else if (croatia.charAt(index) == 's') {
                if (index + 1 < croatia.length() && croatia.charAt(index + 1) == '=') {
                    index += 2;
                } else {
                    index++;
                }
            } else if (croatia.charAt(index) == 'z') {
                if (index + 1 < croatia.length() && croatia.charAt(index + 1) == '=') {
                    index += 2;
                } else {
                    index++;
                }
            } else {
                index++;
            }
            output++;
        }
        System.out.println(output);
    }
}
