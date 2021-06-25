package com.company.해커랭크.easy;

import java.util.HashMap;
import java.util.List;

public class LoonelyInteger2 {
    public static int lonelyinteger(List<Integer> a) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int answer = 0;

        for(int num : a){
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for(int num : hm.keySet()){
            if(hm.get(num) == 1){
                answer = num;
            }
        }

        return answer;
    }
}
