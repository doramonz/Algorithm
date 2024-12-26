package Programmers;

public class Programmers86491 {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        for(int[] size : sizes){
            if(size[0]>size[1]){
                max = Math.max(max,size[0]);
                min = Math.max(min,size[1]);
            }else{
                max = Math.max(max,size[1]);
                min = Math.max(min,size[0]);
            }
        }
        return max*min;
    }
}
