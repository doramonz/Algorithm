package Programmers;

import java.util.Stack;

public class Programmers17687 {
        static String[] st = new String[]{"0","1","2","3","4","5",
"6","7","8","9","A","B","C","D","E","F"};
    static String numToN(int n, int num){
        Stack<String> stack = new Stack<>();
        while(num>=n){
            stack.push(st[num%n]);
            num/=n;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(st[num]);
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int r = 0;
        while(sb.length()<t){
            String number = numToN(n,i);
            for(char c : number.toCharArray()){
                if(r%m==(p-1)){
                    sb.append(c);
                }
                r++;
            }
            i++;
        }
        while(sb.length()>t){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
