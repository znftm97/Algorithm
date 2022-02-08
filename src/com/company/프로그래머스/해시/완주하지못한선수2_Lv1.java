package com.company.프로그래머스.해시;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*hash 이용해서 풀기*/
public class 완주하지못한선수2_Lv1 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        String answer = "";

        for (String name : participant) {
            hm.put(name, hm.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            hm.put(name, hm.get(name)-1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer=key;
                break;
            }
        }

        return answer;
    }
}
