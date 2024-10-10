package BOJ;

import java.io.*;

public class BOJ10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20002];
        int front = 10000;
        int back = 10001;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            switch (command.split(" ")[0]) {
                case "push_front":
                    arr[front--] = Integer.parseInt(command.split(" ")[1]);
                    break;
                case "push_back":
                    arr[back++] = Integer.parseInt(command.split(" ")[1]);
                    break;
                case "pop_front":
                    if (front + 1 == back) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(arr[++front] + "\n");
                    }
                    break;
                case "pop_back":
                    if (back - 1 == front) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(arr[--back] + "\n");
                    }
                    break;
                case "size":
                    sb.append(back - front - 1 + "\n");
                    break;
                case "empty":
                    sb.append(back - front - 1 == 0 ? 1 + "\n" : 0 + "\n");
                    break;
                case "front":
                    if (front + 1 == back) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(arr[front + 1] + "\n");
                    }
                    break;
                case "back":
                    if (back - 1 == front) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(arr[back - 1] + "\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
