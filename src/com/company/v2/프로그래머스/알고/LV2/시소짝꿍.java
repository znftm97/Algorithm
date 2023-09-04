package com.company.v2.프로그래머스.알고.LV2;

import java.util.Arrays;

public class 시소짝꿍 {
    public long solution(int[] weights) {
        long result = 0;
        int len = weights.length;

        Arrays.sort(weights);

        int cnt = 0;
        for(int i = 0; i<len - 1; i++) {
            if(i != 0 && weights[i] == weights[i-1]) {
                cnt--;
                result += cnt;
                continue;
            }
            cnt = 0;

            for(int j = i + 1; j<len; j++) {
                if(isPair(weights, i, j)){
                    cnt++;
                }
            }
            result += cnt;
        }

        return result;
    }

    static boolean isPair(int[] weights, int i, int j) {
        return weights[i] == weights[j] ||
                weights[i] * 3 == weights[j] * 2 ||
                weights[i] * 4 == weights[j] * 2 ||
                weights[i] * 4 == weights[j] * 3;
    }
}
