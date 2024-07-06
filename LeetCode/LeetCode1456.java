package LeetCode;

public class LeetCode1456 {
    public static void main(String[] args) {
        LeetCode1456 l = new LeetCode1456();
        System.out.println(l.maxVowels("abciiidef", 3));
    }

    public int maxVowels(String s, int k) {
        int max = 0;
        int size = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                max++;
            }
        }
        size = max;
        for (int i = 0; i < s.length() - k; i++) {
            if(isVowel(s.charAt(i))){
                size--;
            }
            if(isVowel(s.charAt(i+k))){
                size++;
            }
            if(size>max){
                max=size;
            }
        }
        return max;
    }

    boolean isVowel(char a) {
        return 'a' == a || 'e' == a || 'i' == a || 'o' == a || 'u' == a;
    }
}
