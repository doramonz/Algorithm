package Programmers;

public class Programmers92335 {
    static boolean isPrime(long v){
        if(v==1)
            return false;
        for(long l = 2;l*l<=v;l++){
            if(v%l==0)
                return false;
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String converted = Integer.toString(n,k);
        StringBuilder sb = new StringBuilder();
        for(char c : converted.toCharArray()){
            if(c=='0'){
                if(sb.length()>0&&isPrime(Long.parseLong(sb.toString())))
                    answer++;
                sb.setLength(0);
            }else{
                sb.append(c);
            }
        }
        if(sb.length()>0&&isPrime(Long.parseLong(sb.toString())))
            answer++;
        return answer;
    }
}
