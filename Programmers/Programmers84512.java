package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers84512 {
        static List<Character> dic = new ArrayList<>();
    static char[] d = new char[]{'A','E','I','O','U'};
    static String find;
    static int answer = 0;
    static int count = 0;
    static void recur(){
        if(dic.size()>5)
            return;
        if(dic.size() == find.length()){
            boolean flag = true;
            for(int i = 0;i<dic.size();i++){
                if(dic.get(i)!=find.charAt(i))
                    flag =false;}
            if(flag)
                answer = count;
        }
        for(int i = 0;i<5;i++){
            if(dic.size()==5)
                continue;
            dic.add(d[i]);
            count++;
            recur();
            dic.remove(dic.size()-1);
        }
    }
    public int solution(String word) {
        count = 0;
        find = word;
        recur();
        return answer;
    }
}
