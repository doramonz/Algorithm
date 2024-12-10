package BOJ;

import java.io.*;
import java.util.*;

public class BOJ14405 {
    public static void main(String[] args) throws Exception {
        String s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int index = 0;
        while (index<s.length()) {
            if(s.length()>=index+2&&(s.substring(index,index+2).equals("pi")||s.substring(index,index+2).equals("ka"))){
                index+=2;
            }else if(s.length()>=index+3&&s.substring(index,index+3).equals("chu")){
                index+=3;
            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
        return;
    }
}
