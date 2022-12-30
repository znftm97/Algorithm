package com.company.v2.프로그래머스.알고.LV2;

import java.util.Arrays;

public class 최소값만들기 {
    public int solution(int[] A, int[] B) {
        int result = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = B.length - 1;

        for (int i = 0; i < A.length; i++) {
            result += A[aIdx++] * B[bIdx--];
        }

        return result;
    }
}
