package BOJ;

import java.util.Scanner;

public class BOJ10808 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        scanner.close();
        int[] output = new int[26];
        for(int i = 0;i<text.length();i++){
            output[text.charAt(i)%97]++;
        }
        for(int i = 0;i<26;i++){
            System.out.print(output[i]+" ");
        }
    }
}
