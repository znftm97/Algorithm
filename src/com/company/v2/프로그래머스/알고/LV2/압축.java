package com.company.v2.프로그래머스.알고.LV2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public List<Integer> solution(String msg) {
        List<Integer> results = new ArrayList<>();
        Map<String, Integer> dictionaryMap = new HashMap<>();
        char c = 'A';
        for(int i = 1; i<=26; i++) {
            dictionaryMap.put(String.valueOf(c++), i);
        }

        int mapIdx = 27;
        for (int idx = 0; idx < msg.length(); idx++) {
            if(idx == msg.length() - 1) {
                results.add(dictionaryMap.get(String.valueOf(msg.charAt(idx))));
                break;
            }

            int afterIdx = idx + 1;
            while(true) {
                if(afterIdx >= msg.length()) {
                    results.add(dictionaryMap.get(msg.substring(idx)));
                    return results;
                }

                String word = msg.substring(idx, afterIdx + 1);
                if(dictionaryMap.containsKey(word)) {
                    afterIdx++;
                    continue;
                }

                dictionaryMap.put(word, mapIdx++);
                results.add(dictionaryMap.get(msg.substring(idx, afterIdx)));
                idx = afterIdx - 1;
                break;
            }
        }

        return results;
    }
}
