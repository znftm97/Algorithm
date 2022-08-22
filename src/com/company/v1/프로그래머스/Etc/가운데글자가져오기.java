package com.company.v1.프로그래머스.Etc;

public class 가운데글자가져오기 {
    public String solution(String s) {
        int length = s.length();
        String answer = "";

        if (length % 2 == 0) {
            answer = s.substring(length / 2 - 1, length / 2 + 1);
        } else {
            answer = s.substring(length/2, length/2 + 1);
        }

        return answer;
    }
}
