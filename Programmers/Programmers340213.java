package Programmers;

public class Programmers340213 {
    static int timeToSec(String time){
        return Integer.parseInt(time.substring(0,2))*60+Integer.parseInt(time.substring(3,5));
    }
    static String secToTime(int sec){
        return new StringBuilder().append(sec/600).append(sec%600/60).append(":").append(sec%60/10).append(sec%10).toString();
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        if(timeToSec(pos)>=timeToSec(op_start)&&timeToSec(pos)<=timeToSec(op_end))
            pos = op_end;
        for(String command : commands){
            if(command.equals("prev")){
                int c = timeToSec(pos);
                c-=10;
                if(c<0)
                    c=0;
                pos = secToTime(c);
            }else{
                int c = timeToSec(pos);
                c+=10;
                if(c>timeToSec(video_len))
                    c=timeToSec(video_len);
                pos = secToTime(c);
            }
            if(timeToSec(pos)>=timeToSec(op_start)&&timeToSec(pos)<=timeToSec(op_end))
            pos = op_end;
        }
        return pos;
    }
}
