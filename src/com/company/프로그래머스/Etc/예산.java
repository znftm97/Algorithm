package com.company.프로그래머스.Etc;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int count = 0;
        int sum = 0;

        Arrays.sort(d);
        for (int money : d) {
            if (sum+money > budget) {
                break;
            }
            sum += money;
            count++;
        }

        return count;
    }
}
