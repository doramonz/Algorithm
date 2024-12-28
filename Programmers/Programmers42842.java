package Programmers;

public class Programmers42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int x = 1;x<=yellow/2+1;x++){
            int y = yellow/x;
            if(y==0)
                y=1;
            if(x*y!=yellow)
                continue;
            if((y+2)*2+x*2==brown){
                answer[0] = y+2;
                answer[1] = x+2;
                break;
            }
        }
        return answer;
    }
}
