package com.company.v2.코드트리.프로그래밍연습.완탐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int result = 0;

        for (int num = x; num <= y; num++) {
            boolean isPalindrome = true;
            String s = String.valueOf(num);
            int startIdx = 0;
            int endIdx = s.length() - 1;

            while (startIdx < endIdx) {
                if (s.charAt(startIdx) == s.charAt(endIdx)) {
                    startIdx++;
                    endIdx--;
                } else {
                    isPalindrome = false;
                    break;
                }
            }

            if (isPalindrome) {
                result++;
            }
        }

        System.out.println(result);
    }
}
