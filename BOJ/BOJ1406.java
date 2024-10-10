package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1406 {
    static class Cursor {
        Cursor prev;
        Cursor next;
        Character data;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Cursor init = new Cursor();
        Cursor temp = init;
        init.prev = null;
        for (int i = 0; i < s.length(); i++) {
            Cursor cursor = new Cursor();
            temp.next = cursor;
            cursor.prev = temp;
            cursor.data = s.charAt(i);
            temp = cursor;
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            switch (input.charAt(0)) {
                case 'L':
                    if (temp.prev != null)
                        temp = temp.prev;
                    break;
                case 'D':
                    if (temp.next != null)
                        temp = temp.next;
                    break;
                case 'B':
                    if (temp != init) {
                        temp.prev.next = temp.next;
                        if (temp.next != null)
                            temp.next.prev = temp.prev;
                        temp = temp.prev;
                    }
                    break;
                case 'P':
                    Cursor cursor = new Cursor();
                    cursor.data = input.charAt(2);
                    cursor.prev = temp;
                    cursor.next = temp.next;
                    temp.next = cursor;
                    temp = cursor;
                    break;
            }
        }
        br.close();
        init = init.next;
        while (init != null) {
            System.out.print(init.data);
            init = init.next;
        }
    }
}
