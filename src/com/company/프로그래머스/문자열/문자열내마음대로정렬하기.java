package com.company.프로그래머스.문자열;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);

            if(c1 == c2){
                return s1.compareTo(s2); // s1 > s2 => -1 반환 => 음수 반환하면 자리 바꾸지 않음
            } else return c1 - c2; // c2 > c1 => 음수 반환 => 자리 바꾸지 않음
        });

        return strings;
    }
}
