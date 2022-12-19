package com.company.v1.프로그래머스.LV2;

import java.util.ArrayList;
import java.util.List;

public class n제곱배열자르기 {
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> result = new ArrayList<>();

        for (long i = 0; i < right - left + 1; i++) {
            long r = (i + left) / n + 1;
            long c = (i + left) % n + 1;
            result.add((int) Math.max(r, c));
        }

        return result;
    }

}
