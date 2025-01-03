package Programmers;

public class Programmers49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] arr = new int[26];
        int index = 1;
        for(char c : skill.toCharArray())
            arr[c-'A'] = index++;
        for(String skill_tree : skill_trees){
            index = 1;
            boolean flag = false;
            for(char c : skill_tree.toCharArray())
                if(arr[c-'A']!=0&&index++!=arr[c-'A']){
                    flag = true;
                    break;
                }
            if(!flag)
                answer++;
        }
        return answer;
    }
}
