package com.company.동빈북.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱하기혹은더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int num = s.charAt(0) - 48;

        for (int i = 1; i < s.length(); i++) {
            int nextNum = s.charAt(i) - 48;
            if (num <= 1 || nextNum <= 1) {
                num += nextNum;
            } else {
                num *= nextNum;
            }
        }

        System.out.println(num);
    }
}
