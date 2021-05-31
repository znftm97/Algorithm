package com.company.프로그래머스.Etc;

public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        for (int i = Math.min(a,b); i <= Math.max(a,b); i++) {
            answer += i;
        }
        return answer;
    }
}
