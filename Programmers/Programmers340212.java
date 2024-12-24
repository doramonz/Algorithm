package Programmers;

public class Programmers340212 {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        while(left<right){
        int level = (left+right)/2;
            long copy_limit = limit;
            for(int i = 0;i<diffs.length;i++){
                if(level<diffs[i]){
                    copy_limit-=(diffs[i]-level)*(times[i-1]+times[i])+times[i];
                }else{
                    copy_limit-=times[i];
                }
            }
            if(copy_limit<0){
                left = level + 1;
            }else{
                right = level;
            }
        }
        return left;
    }
}
