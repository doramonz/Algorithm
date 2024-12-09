package Programmers;

public class Programmers12980 {
    static public int solution(int n) {
        int ans = 0;
        while (n>0) {
            if(n%2==0){
                n/=2;
            }else{
                n--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));// 2
        System.out.println(solution(6));// 2
        System.out.println(solution(5000));;// 5
    }
}
