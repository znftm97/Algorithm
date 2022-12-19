package com.company.v1.프로그래머스.LV2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result[i]++;
                if (prices[i] > prices[j]) break;
            }
        }

        result[prices.length - 1] = 0;
        return result;
    }

}
