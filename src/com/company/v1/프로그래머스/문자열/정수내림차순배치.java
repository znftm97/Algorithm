package com.company.v1.프로그래머스.문자열;

import java.util.Arrays;

public class 정수내림차순배치 {
    public long solution(long n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();

        Arrays.sort(arr);
        String str = new String(arr);
        StringBuilder sb = new StringBuilder(str).reverse();

        return Long.parseLong(sb.toString());
    }
}
