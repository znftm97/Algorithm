package com.company.프로그래머스.문자열;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    return false;
                }
            }
        } else {
            return false;
        }

        return answer;
    }
}
