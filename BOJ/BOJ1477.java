package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1477 {

    private static int minMaxHighWayRestArea(int n, int size, int[] restAreas) {
        Arrays.sort(restAreas);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(restAreas[0]);
        for (int i = 1; i < restAreas.length; i++) {
            queue.add(restAreas[i] - restAreas[i - 1]);
        }
        queue.add(size - restAreas[restAreas.length - 1]);

        for (int i = 0; i < n; i++) {
            int poll = queue.poll();
            if (poll % 2 == 0) {
                queue.add(poll / 2);
                queue.add(poll / 2);
            } else {
                queue.add(poll / 2);
                queue.add(poll / 2 + 1);
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input, n, size;
        input = scanner.nextInt();
        n = scanner.nextInt();
        size = scanner.nextInt();
        int[] restAreas = new int[input];
        for (int i = 0; i < input; i++) {
            restAreas[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(minMaxHighWayRestArea(n, size, restAreas));
    }

}
