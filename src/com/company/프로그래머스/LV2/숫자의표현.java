package com.company.프로그래머스.LV2;

public class 숫자의표현 {
    public int solution(int n) {

        int result = 0;
        for (int i = 1; i <= n / 2; i++) {
            int sum = i;

            for (int j = i+1; j <= n; j++) {
                sum += j;

                if (sum == n) {
                    result++;
                    break;
                } else if (sum > n) break;
            }

        }

        return result + 1;
    }

}
