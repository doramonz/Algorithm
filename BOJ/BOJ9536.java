package BOJ;

import java.io.*;
import java.util.*;

public class BOJ9536 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t_case = Integer.parseInt(br.readLine());
        for (int t = 0; t < t_case; t++) {
            List<String> list = new ArrayList<>();
            for (String s : br.readLine().split(" ")) {
                list.add(s);
            }
            String line;

            while (!(line = br.readLine()).equals("what does the fox say?")) {
                String[] temp = line.split(" ");
                while (list.contains(temp[temp.length - 1])) {
                    list.remove(temp[temp.length - 1]);
                }
            }
            for(String s : list){
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
