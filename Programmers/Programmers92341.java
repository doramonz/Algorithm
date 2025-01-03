package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Programmers92341 {
        public int[] solution(int[] fees, String[] records) {
        Map<String, String> enter = new HashMap<>();
        Map<String, Integer> time = new HashMap<>();
        for(String record : records){
            String[] temp = record.split(" ");
            if(enter.containsKey(temp[1])){
                time.put(temp[1],time.getOrDefault(temp[1],0)+(Integer.parseInt(temp[0].split(":")[0])-Integer.parseInt(enter.get(temp[1]).split(":")[0]))*60+Integer.parseInt(temp[0].split(":")[1])-Integer.parseInt(enter.get(temp[1]).split(":")[1]));
                enter.remove(temp[1]);
            }else{
                enter.put(temp[1],temp[0]);
            }
        }
        for(String key : enter.keySet()){
            time.put(key, time.getOrDefault(key,0)+(23-Integer.parseInt(enter.get(key).split(":")[0]))*60+59-Integer.parseInt(enter.get(key).split(":")[1]));
        }
        TreeMap<String, Integer> result = new TreeMap<>();
        for(String key : time.keySet()){
            result.put(key,fees[1]+((time.get(key)-fees[0])<0?0:(int)(Math.ceil((time.get(key)-fees[0])/(float)fees[2])*fees[3])));
        }
        int[] answer = new int[result.size()];
        int index = 0;
        for(String key : result.keySet()){
            answer[index++] = result.get(key);
        }
        
        return answer;
    }
}
