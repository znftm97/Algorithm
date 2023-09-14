package com.company.v2.프로그래머스.알고.LV2;

import java.util.*;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantToNumMap = new HashMap<>();
        int result = 0;

        for(int i = 0; i<want.length; i++) {
            wantToNumMap.put(want[i], number[i]);
        }

        int len = discount.length - 10;
        for(int i = 0; i<=len; i++) {
            Map<String, Integer> map = new HashMap<>(wantToNumMap);
            boolean flag = true;

            for(int j = i; j<i+10; j++) {
                String product = discount[j];
                if(!wantToNumMap.containsKey(product) || map.get(product) == 0) {
                    flag = false;
                    break;
                }
                map.put(product, map.get(product) - 1);
            }

            if(flag) {
                result++;
            }
        }

        return result;
    }
}
