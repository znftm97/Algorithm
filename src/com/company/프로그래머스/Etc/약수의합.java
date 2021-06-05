package com.company.프로그래머스.Etc;

public class 약수의합 {
    public int solution(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
