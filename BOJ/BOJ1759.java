package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1759 {
    static int l;
    static int c;
    static char[] arr;
    static Set<Character> set = new HashSet<>();
    static List<Character> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void recur(int count, int index) {
        if (count == c) {
            StringBuilder temp = new StringBuilder();
            int vowel = 0;
            int consonant = 0;
            for (char cha : list) {
                if (set.contains(cha)) {
                    vowel++;
                } else {
                    consonant++;
                }
                temp.append(cha);
            }
            if (vowel < 1 || consonant < 2)
                return;
            sb.append(temp).append("\n");
            return;
        }
        for (int i = index; i < l; i++) {
            list.add(arr[i]);
            recur(count + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        arr = new char[l];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < l; i++)
            arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        recur(0, 0);
        System.out.println(sb);
    }
}
