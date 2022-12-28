package com.company.v2.프로그래머스.알고.LV2;

public class 점프와순간이동 {
    public int solution(int n) {
        int result = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                result++;
            }
        }

        return result;
    }

}
