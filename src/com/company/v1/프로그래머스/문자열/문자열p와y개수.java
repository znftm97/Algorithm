package com.company.v1.프로그래머스.문자열;

public class 문자열p와y개수 {
    boolean solution(String s) {
        String s1 = s.toLowerCase();
        int[] check = new int[2];

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'p') {
                check[0]++;
            } else if (s1.charAt(i) == 'y') {
                check[1]++;
            }
        }

        if (check[0] != check[1]) {
            return false;
        } else {
            return true;
        }
    }
}
