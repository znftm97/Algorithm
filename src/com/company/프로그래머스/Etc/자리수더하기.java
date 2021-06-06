package com.company.프로그래머스.Etc;

public class 자리수더하기 {
    public int solution(int n) {
        String s = String.valueOf(n);
        String[] arr = s.split("");
        int sum = 0;

        for (String str : arr) {
            sum += Integer.valueOf(str);
        }

        return sum;
    }
}
