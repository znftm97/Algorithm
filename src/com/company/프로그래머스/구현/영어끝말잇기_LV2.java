package com.company.프로그래머스.구현;

import java.util.*;

public class 영어끝말잇기_LV2 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashMap<String, Integer> map = new HashMap<>();

        map.put(words[0], map.getOrDefault(words[0], 0) + 1);

        for(int i = 1; i<words.length; i++){
            String str = words[i];
            map.put(str, map.getOrDefault(str, 0) + 1);

            if(str.length() == 1 || map.get(str) > 1){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            } else if(words[i-1].charAt(words[i-1].length() - 1) != str.charAt(0)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                return answer;
            }
        }

        return answer;
    }
}
