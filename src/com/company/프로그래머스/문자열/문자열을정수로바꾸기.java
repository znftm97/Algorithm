package com.company.프로그래머스.문자열;

public class 문자열을정수로바꾸기 {
    public int solution(String s) {
        int answer = 0;
        answer = s.charAt(0) == '-' ? Integer.parseInt(s.substring(1)) * -1 : Integer.parseInt(s);

        return answer;
    }
}
