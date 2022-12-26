package com.company.v2.프로그래머스.알고.LV2;

public class 숫자의표현 {
    public int solution(int n) {
        int caseCnt = 0;

        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = i; j <= n; j++) {
                sum += j;

                if (sum == n) {
                    caseCnt++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return caseCnt;
    }
}
