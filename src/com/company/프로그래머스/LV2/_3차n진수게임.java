package com.company.프로그래머스.LV2;

public class _3차n진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder convertNums = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m * t; i++) {
            convertNums.append(Integer.toString(i, n));
        }

        for (int i = p - 1; i < m*t; i += m) {
            result.append(convertNums.charAt(i));
        }

        return result.toString().toUpperCase();
    }

}
