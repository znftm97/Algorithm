package com.company.v2.프로그래머스.알고.LV2;

import java.util.Arrays;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int c = col - 1;
        int startR = row_begin - 1;
        int endR = row_end - 1;

        Arrays.sort(data, (o1, o2) -> o1[c] == o2[c] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[c], o2[c]));

        int result = 0;
        for(int i = startR; i<=endR; i++) {
            int sum = 0;
            for(int j = 0; j<data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            result ^= sum;
        }

        return result;
    }
}
