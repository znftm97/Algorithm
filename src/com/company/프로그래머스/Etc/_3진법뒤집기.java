package com.company.프로그래머스.Etc;

public class _3진법뒤집기 {
    public int solution(int n) {
        String answer = "";

        while (n > 0) {
            answer = (n % 3) + answer;
            n /= 3;
        }

        answer = new StringBuilder(answer).reverse().toString();

        return Integer.valueOf(answer, 3);
    }
}
