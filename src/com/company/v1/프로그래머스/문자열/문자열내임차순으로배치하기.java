package com.company.v1.프로그래머스.문자열;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내임차순으로배치하기 {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");

        Arrays.sort(arr);
        Arrays.sort(arr, Collections.reverseOrder());

        for (String str : arr) {
            answer += str;
        }

        return answer;
    }
}
