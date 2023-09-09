package com.company.v2.프로그래머스.알고.LV2;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    static Map<Integer, Integer> left = new HashMap<>();
    static Map<Integer, Integer> right = new HashMap<>();

    public int solution(int[] topping) {
        int result = 0;

        for(int i = 0; i<topping.length; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }

        for(int i = 0; i<topping.length - 1; i++) {
            if(isEqualTopping(topping[i])) result++;
        }

        return result;
    }

    static boolean isEqualTopping(int num) {
        if(left.containsKey(num)) left.put(num, left.get(num) + 1);
        else left.put(num, 1);

        if(right.containsKey(num)) {
            int cnt = right.get(num);

            if(cnt == 1) right.remove(num);
            else right.put(num, cnt - 1);
        }

        return left.size() == right.size();
    }
}
