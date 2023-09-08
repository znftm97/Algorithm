package com.company.v2.프로그래머스.알고.LV2;

import java.util.Arrays;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int[] cnts = new int[10000001];
        for(int size : tangerine) {
            cnts[size]++;
        }

        Arrays.sort(cnts);

        int result = 0;
        for(int i = cnts.length - 1; i > 0; i--) {
            result++;
            k -= cnts[i];

            if(k <= 0) {
                break;
            }
        }

        return result;
    }
}
