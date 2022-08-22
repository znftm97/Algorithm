package com.company.v1.프로그래머스.LV2;

import java.util.StringTokenizer;

public class 최댓값과최솟값 {
    public String solution(String s) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        StringBuilder sb = new StringBuilder();
        return sb.append(min).append(" ").append(max).toString();
    }

}
